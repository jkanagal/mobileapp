package com.example.myapplication_smartblinds;

import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class auto_page extends AppCompatActivity {

    MemoryPersistence persistence = new MemoryPersistence();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_page);

        TextView currentTemp = findViewById(R.id.currentTemp);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (this) {
                            try {
                                receive(currentTemp);
                            } catch (Exception e) {
                                Log.d("UI Thread", "Error");
                            }
                        }
                    }
                });
            }
        });
        thread.start();
    }

    private void receive(TextView currentTemp) throws Exception {
                MqttClient client = new MqttClient("tcp://broker.hivemq.com:1883", "SmartBlindsApp", persistence);
        MqttCallback callback = new MqttCallback() {

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {

                Log.d("MessageArrived", String.valueOf(message));
                runOnUiThread(new Runnable()
                {
                    public void run()
                    {
                        currentTemp.setText(String.valueOf(message));
                    }
                });
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {

            }

            @Override
            public void connectionLost(Throwable cause) {
                cause.printStackTrace();
            }
        };
        client.connect();
        Log.d("Connect", "connected");
        client.subscribe("smartblindspub");
        client.setCallback(callback);
    }

    public void setTemp (View view){
        Log.d("setTemp", "Function called!");
        String topic        = "getDesiredTemp";
        int qos             = 2;
        String broker       = "tcp://broker.hivemq.com:1883";
        String clientId     = "SmartBlindsApp";
        EditText desiredTemp = findViewById(R.id.desiredTemp);

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(false);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+ desiredTemp.getText().toString());
            MqttMessage message = new MqttMessage(desiredTemp.getText().toString().getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            sampleClient.disconnect();
            System.out.println("Disconnected");
        } catch(MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
}