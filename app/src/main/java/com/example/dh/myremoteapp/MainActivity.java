package com.example.dh.myremoteapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    Button numb1;
    Button numb2;
    Button numb3;
    Button numb4;
    Button numb5;
    Button numb6;
    Button numb7;
    Button numb8;
    Button numb9;
    Button numb0;
    Button btnAdd;
    Button btnSub;
    Switch sw;
    TextView tvPower;
    TextView tvSpeaker;
    TextView tvChnl;
    TextView tv;
    String value = "";
    String preValue = "";
    SeekBar sb;
    Integer volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numb1 = (Button) this.findViewById(R.id.btn1);
        numb1.setOnClickListener(this);
        numb2 = (Button) this.findViewById(R.id.btn2);
        numb2.setOnClickListener(this);
        numb3 = (Button) this.findViewById(R.id.btn3);
        numb3.setOnClickListener(this);
        numb4 = (Button) this.findViewById(R.id.btn4);
        numb4.setOnClickListener(this);
        numb5 = (Button) this.findViewById(R.id.btn5);
        numb5.setOnClickListener(this);
        numb6 = (Button) this.findViewById(R.id.btn6);
        numb6.setOnClickListener(this);
        numb7 = (Button) this.findViewById(R.id.btn7);
        numb7.setOnClickListener(this);
        numb8 = (Button) this.findViewById(R.id.btn8);
        numb8.setOnClickListener(this);
        numb9 = (Button) this.findViewById(R.id.btn9);
        numb9.setOnClickListener(this);
        numb0 = (Button) this.findViewById(R.id.btn0);
        numb0.setOnClickListener(this);
        sw = (Switch) this.findViewById(R.id.sw1);
        sw.setOnClickListener(this);
        tvPower = (TextView) this.findViewById(R.id.tv5);
        tvPower.setOnClickListener(this);
        tvChnl = (TextView) this.findViewById(R.id.tv7);
        tvChnl.setOnClickListener(this);
        tvSpeaker = (TextView) this.findViewById(R.id.tv6);
        tvSpeaker.setOnClickListener(this);
        sb = (SeekBar) this.findViewById(R.id.sb1);
        sb.setOnSeekBarChangeListener(this);
        btnAdd = (Button) this.findViewById(R.id.btnAddChnl);
        btnAdd.setOnClickListener(this);
        btnSub = (Button) this.findViewById(R.id.btnSubtChnl);
        btnSub.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if (v == numb1 && sw.isChecked()) {
            value = numb1.getText().toString();
        } else if (v == numb2 && sw.isChecked()) {
            value = numb2.getText().toString();
        } else if (v == numb3 && sw.isChecked()) {
            value = numb3.getText().toString();
        } else if (v == numb4 && sw.isChecked()) {
            value = numb4.getText().toString();
        } else if (v == numb5 && sw.isChecked()) {
            value = numb5.getText().toString();
        } else if (v == numb6 && sw.isChecked()) {
            value = numb6.getText().toString();
        } else if (v == numb7 && sw.isChecked()) {
            value = numb7.getText().toString();
        } else if (v == numb8 && sw.isChecked()) {
            value = numb8.getText().toString();
        } else if (v == numb9 && sw.isChecked()) {
            value = numb9.getText().toString();
        } else if (v == numb0 && sw.isChecked()) {
            value = numb0.getText().toString();
        } else if (v == sw) {
            if (sw.isChecked()) {
                tvPower.setText(String.valueOf(sw.getTextOn().toString()));
                sb.setProgress(15);
                volume = sb.getProgress();
                tvSpeaker.setText(volume.toString());
            } else {
                tvPower.setText(String.valueOf(sw.getTextOff().toString()));
                volume = 0;
                tvSpeaker.setText(volume.toString());
                value = "";
                tvChnl.setText(value);
                sb.setProgress(0);
            }
        } else if (v == sb && sw.isChecked()) {
            volume = sb.getProgress();
            tvSpeaker.setText(volume.toString());
        } else if (v == btnAdd) {
            if ((Integer.valueOf(value)).intValue() < 99) {
                value = String.valueOf((Integer.valueOf(value)).intValue() + 1).toString();
            } else {
                value = "0";
            }
        } else if (v == btnSub) {
            if ((Integer.valueOf(value)).intValue() > 0) {
                value = String.valueOf((Integer.valueOf(value)).intValue() - 1).toString();
            } else {
                value = "99";
            }
        }
        tvChnl.setText(value);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (sw.isChecked()) {
            volume = i;
            tvSpeaker.setText(volume.toString());
        } else {
            sb.setProgress(0);
            onStopTrackingTouch(sb);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}