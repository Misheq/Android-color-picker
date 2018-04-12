package com.example.i333373.colorpicker;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextRedValue;
    private TextView mTextGreenValue;
    private TextView mTextBlueValue;
    private SeekBar mRedBar;
    private SeekBar mGreenBar;
    private SeekBar mBlueBar;
    private ImageView mColorView;
    private View mDialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflateView();
        getColorText();
        initializeSeekBars();
    }

    public void selectColor(View view) {
        createAlertDialog();
    }

    private void inflateView() {
        LayoutInflater inflater = this.getLayoutInflater();
        mDialogView = inflater.inflate(R.layout.custom_dialog, null);
    }

    private void getColorText() {
        mTextRedValue = mDialogView.findViewById(R.id.tv_red_value);
        mTextGreenValue = mDialogView.findViewById(R.id.tv_green_value);
        mTextBlueValue = mDialogView.findViewById(R.id.tv_blue_value);
        mColorView = mDialogView.findViewById(R.id.iv_colorview);
    }

    private void initializeSeekBars() {

        mRedBar = mDialogView.findViewById(R.id.sb_red_value);
        mGreenBar = mDialogView.findViewById(R.id.sb_green_value);
        mBlueBar = mDialogView.findViewById(R.id.sb_blue_value);

        mTextRedValue.setText("Red value: " + mRedBar.getProgress());
        mTextGreenValue.setText("Green value: " + mGreenBar.getProgress());
        mTextBlueValue.setText("Blue value: " + mBlueBar.getProgress());
        updateImageViewColor();

        mRedBar.setOnSeekBarChangeListener(seekBarChangeListener);
        mGreenBar.setOnSeekBarChangeListener(seekBarChangeListener);
        mBlueBar.setOnSeekBarChangeListener(seekBarChangeListener);
    }

    private void updateImageViewColor() {
        mColorView.setBackgroundColor(Color.rgb(mRedBar.getProgress(), mGreenBar.getProgress(), mBlueBar.getProgress()));
    }

    private void createAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setPositiveButton(R.string.dialog_select, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // pass color down
            }
        });

        builder.setTitle(R.string.dialog_title)
                .setView(mDialogView);

        builder.show();
    }

    SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
            if (seekBar.getId() == R.id.sb_red_value) {
                mTextRedValue.setText("Red value: " + progress);
            } else if (seekBar.getId() == R.id.sb_green_value) {
                mTextGreenValue.setText("Green value: " + progress);
            } else if (seekBar.getId() == R.id.sb_blue_value) {
                mTextBlueValue.setText("Blue value: " + progress);
            }

            updateImageViewColor();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

}
