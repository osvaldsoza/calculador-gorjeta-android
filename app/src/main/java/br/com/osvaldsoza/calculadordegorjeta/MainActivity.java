package br.com.osvaldsoza.calculadordegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView txtGorjeta;
    private TextView txtTotal;
    private TextView txtPercent;
    private TextInputEditText editValor;
    private double percentual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        txtPercent = findViewById(R.id.txtPercent);
        txtGorjeta = findViewById(R.id.txtGorjeta);
        txtTotal = findViewById(R.id.txtTotal);
        editValor = findViewById(R.id.editValor);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentual = progress;
                txtPercent.setText(Math.round(percentual) + "%");

                calcularGorjeta(percentual);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void calcularGorjeta(double percentual) {
        String getValorDigitado = editValor.getText().toString();

        if (getValorDigitado.isEmpty()) {
            Toast.makeText(this.getApplicationContext(), "Digite o valor da conta!", Toast.LENGTH_SHORT).show();
        } else {
            double valorConta = Double.parseDouble(getValorDigitado);
            double gorjeta = (valorConta * percentual) / 100;
            double total = valorConta + gorjeta;

            txtGorjeta.setText("R$ " + gorjeta);
            txtTotal.setText("R$ " + total);
        }
    }
}
