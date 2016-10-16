package id.sch.smktelkom_mlg.tugas01.xirpl3008.pendaftaranbasket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etSekolah;
    EditText etNomor;
    EditText etAlamat;
    TextView tvHasil;
    TextView etJK;
    Button bOK;
    RadioButton rb1;
    RadioButton rb2;
    RadioGroup rgStatus;
    Spinner sp;
    CheckBox popda, o2sn, kobalajar, tdk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etSekolah = (EditText) findViewById(R.id.editTextSekolah);
        etNomor = (EditText) findViewById(R.id.editTextNo);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        bOK = (Button) findViewById(R.id.button);
        rb1 = (RadioButton) findViewById(R.id.radioButtonPerempuan);
        rb2 = (RadioButton) findViewById(R.id.radioButtonLaki);
        etJK = (TextView) findViewById(R.id.textView6);
        rgStatus = (RadioGroup) findViewById(R.id.RadioGroupStatus);
        sp = (Spinner) findViewById(R.id.spinner);
        popda = (CheckBox) findViewById(R.id.checkBoxPopda);
        o2sn = (CheckBox) findViewById(R.id.checkBoxO2sn);
        kobalajar = (CheckBox) findViewById(R.id.checkBoxKobalajar);
        tdk = (CheckBox) findViewById(R.id.checkBox);

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProses();
            }
        });

    }

    private void doProses() {

            String nama = etNama.getText().toString();
            String sekolah = etSekolah.getText().toString();
            int nomor = Integer.parseInt(etNomor.getText().toString());
            String alamat = etAlamat.getText().toString();
        String hasil = "\n Jenis Kelamin    : ";
        String posisi = sp.getSelectedItem().toString();
        String pres = "\n Prestasi      : ";

        int startlen = pres.length();
        if (popda.isChecked()) pres += popda.getText() + ",";
        if (o2sn.isChecked()) pres += o2sn.getText() + ",";
        if (kobalajar.isChecked()) pres += kobalajar.getText() + ",";
        if (tdk.isChecked()) pres += tdk.getText();
        if (pres.length() == startlen) pres += "Anda belum memilih";

        if (rgStatus.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgStatus.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");

        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");

        } else {
            etNama.setError(null);
        }


        if (sekolah.isEmpty()) {
            etSekolah.setError("Sekolah Belum Diisi");

        } else {
            etSekolah.setError(null);
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat Belum Diisi");

        } else {
            etAlamat.setError(null);
        }

        tvHasil.setText("-----DATA TERKIRIM-----" + "\nNama       : " + nama + "\n Sekolah     : " + sekolah
                + "\n No.Telp     : " + nomor + "\nAlamat     : " + alamat + "\nJenis Kelamin : " + hasil + "\n Prestasi   : " + pres + "\n Posisi    : " + sp.getSelectedItem().toString());
    }
}
