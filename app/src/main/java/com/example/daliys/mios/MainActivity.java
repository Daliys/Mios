package com.example.daliys.mios;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.UUID;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    BluetoothSocket bluetoothSocket;

    ArrayAdapter<String> arrayAdapter;
    ListView listViewDevice;
    TextView messText;
    Button Body;
    Button Video;
    Button nextPage;

    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewDevice = (ListView)findViewById(R.id.ListVievDevice);
        messText = (TextView)findViewById(R.id.MessText);
        nextPage = (Button)findViewById(R.id.button2);

        InitializationBluetooth();

        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingsBody.class);
                startActivity(intent);
                finish();
            }
        });

        listViewDevice.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Mac = parent.getAdapter().getItem(position)+"";
                Mac = Mac.substring((Mac.length()-17));         // достаем из строки подстроку мас
                messText.setText("MAC:"+Mac);
                ConnectBluetooth(Mac);          // пробуем подключиться по мас'у
            }
        });
        Body = (Button)findViewById(R.id.SeetingValue);
        Body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SettingsBody.class);
                startActivity(intent);
                finish();
            }
        });
        Video = (Button)findViewById(R.id.Video);
        Video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Video.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void InitializationBluetooth(){
        if(bluetoothAdapter != null){       // проверка на наличие Bluetooth
            long StartTimer = System.currentTimeMillis();
            long PastTime = 0;
            while ((!bluetoothAdapter.isEnabled()) && (PastTime < 5000)) {    //попытка включить блютуз в течении 5 сек
                PastTime = System.currentTimeMillis() - StartTimer;
                bluetoothAdapter.enable();
                try {
                    sleep(950);
                } catch (Exception e) {
                    Log.e("Thread","Error Sleep Thread");
                }
            }

            if(bluetoothAdapter.isEnabled()){       // проверка включился ли bluetooth
                FindDeviceBluetooth();

            }else{                          //если блютуз после 5 сек не включился то закрыть приложение
                AlertDialog.Builder buider = new AlertDialog.Builder(MainActivity.this);
                buider.setTitle("Критическая ошибка")
                        .setCancelable(false)
                        .setMessage("Ошибка при включении Bluetooth.\n(Приложении будет закрыто)")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                                finish();
                            }
                        });
                buider.show();
            }

        }else{      // если bluetooth нет то вывести ошибку
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Критическая ошибка")
                    .setCancelable(false)
                    .setMessage("Отсуствие Bluetooth или ошибки при его обнаружении и подключении.\n(Приложении будет закрыто)")
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                            finish();
                        }
                    });
        }
    }
/*
ArrayAdapter является простейшим адаптером, который специально предназначен для работы
с элементами списка типа ListView, Spinner, GridView и им подобным.

В параметрах используется контекст, XML-разметка для отдельного элемента списка и массив данных.
Контекстом может быть сама активность (this), под разметкой подразумевается компонент,
в котором выводится текст, например, TextView, а данными является подготовленный массив,
все элементы которого по очереди вставляются в указанную разметку.

(Мы создась xml файл myitemlist.xml для этого)
 */
    private void FindDeviceBluetooth() {
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        arrayAdapter = new ArrayAdapter<>(this, R.layout.myitemlist);
        // Если список спаренных устройств не пуст
        if (pairedDevices.size() > 0) {
            // проходимся в цикле по этому списку
            for (BluetoothDevice device : pairedDevices) {
                // Добавляем имена и адреса в mArrayAdapter, чтобы показать
                // через ListView
                arrayAdapter.add(device.getName() + "\n" + device.getAddress());
            }
        }
        listViewDevice.setAdapter(arrayAdapter);        //слушатель событий на Лист с bluetooth устройствами

    }

    private void ConnectBluetooth(final String mac){
        messText.setText("Connecting wait...");
        Thread ThreadConnectBluetooth = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BluetoothDevice device = bluetoothAdapter.getRemoteDevice(mac);
                    bluetoothSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
                    if(bluetoothAdapter.isDiscovering()) {
                        bluetoothAdapter.cancelDiscovery();
                    }
                    bluetoothSocket.connect();

                } catch (Exception e) {
                    Log.e("Bluetooth",e+"");
                }
            }
        });
        ThreadConnectBluetooth.start();

        try {
            ThreadConnectBluetooth.join();
            if(bluetoothSocket.isConnected()){
                messText.setText("Connected:"+mac);
                listViewDevice.setVisibility(View.INVISIBLE);
                messText.setVisibility(View.INVISIBLE);
                Video.setVisibility(View.VISIBLE);
                Body.setVisibility(View.VISIBLE);

            }else{
                messText.setText("not Connected");
            }
        }catch (Exception e){
            messText.setText("not Connected");
        }

    }

}
