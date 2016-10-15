package id.sch.smktelkom_mlg.tugas01.xirpl3008.pendaftaranbasket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    EditText etSekolah;
    EditText etNomor;
    EditText etAlamat;
    TextView tvHasil;
    Button bOK;

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

        bOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProses();
            }
        });

    }

    private void doProses() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String sekolah = etSekolah.getText().toString();
            int nomor = Integer.parseInt(etNomor.getText().toString());
            String alamat = etAlamat.getText().toString();
            tvHasil.setText("\n Nama        : " + nama + "\n Sekolah    : " + sekolah + "\n No.Telp     : " + nomor + "\n Alamat      : " + alamat);
        }
    }

    private boolean isValid() {

        boolean valid = true;

        String nama = etNama.getText().toString();
        String sekolah = etSekolah.getText().toString();
        String alamat = etAlamat.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (sekolah.isEmpty()) {
            etSekolah.setError("Sekolah Belum Diisi");
            valid = false;
        } else {
            etSekolah.setError(null);
        }

        if (alamat.isEmpty()) {
            etAlamat.setError("Alamat Belum Diisi");
            valid = false;
        } else {
            etAlamat.setError(null);
        }
        return valid;
    }
}
