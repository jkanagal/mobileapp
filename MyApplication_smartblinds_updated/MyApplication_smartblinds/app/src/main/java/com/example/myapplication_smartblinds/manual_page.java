package com.example.myapplication_smartblinds;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class manual_page extends AppCompatActivity {

    MemoryPersistence persistence = new MemoryPersistence();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_page);


    }

    public void blindsUp (View view){
        String topic        = "BlindTest";
        String content      = "OPEN";
        int qos             = 2;
        String broker       = "tcp://broker.hivemq.com:1883";
        String clientId     = "SmartBlindsApp";
        TextView buttonPressConf = findViewById(R.id.buttonPressConfirmation);

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(false);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            buttonPressConf.setText("OPENING!");
            sampleClient.disconnect();
            System.out.println("Disconnected");
            //System.exit(0);
        } catch(MqttException me) {
            buttonPressConf.setText("UNABLE TO OPEN!");
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }

    public void blindsDown (View view){
        String topic        = "BlindTest";
        String content      = "CLOSE";
        int qos             = 2;
        String broker       = "tcp://broker.hivemq.com:1883";
        String clientId     = "SmartBlindsApp";
        TextView buttonPressConf = findViewById(R.id.buttonPressConfirmation);

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(false);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");
            buttonPressConf.setText("CLOSING!");
            sampleClient.disconnect();
            System.out.println("Disconnected");
            //System.exit(0);
        } catch(MqttException me) {
            buttonPressConf.setText("UNABLE TO CLOSE!");
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
}