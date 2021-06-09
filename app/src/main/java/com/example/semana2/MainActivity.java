package com.example.semana2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    //Declaración de variables

    private EditText nombre;
//    private EditText fecha;
    private EditText telefono;
    private EditText email;
    private EditText descripcion;


    // Declaración de variables

    private  EditText eTfecha;


    public void fecha(View view) {
        Calendar calendario = Calendar.getInstance();
        int a = calendario.get(Calendar.YEAR);
        int m = calendario.get(Calendar.MONTH);
        int d = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dateP = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String fecha = dayOfMonth +"/" + month + "/" + year;
                eTfecha.setText(fecha);

            }
        },a,m,d);

        dateP.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombreUsuario);
        telefono = (EditText) findViewById(R.id.telefono);
        email = (EditText) findViewById(R.id.email);
        descripcion = (EditText) findViewById(R.id.descripcion);
        eTfecha = (EditText) findViewById(R.id.fechaNacimiento);


        Button botonsiguiente = (Button) findViewById(R.id.boton);

        botonsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,DatosConfirmacion.class);
                i.putExtra("Nombre", nombre.getText().toString());
                i.putExtra("Telefono", telefono.getText().toString());
                i.putExtra("Email", email.getText().toString());
                i.putExtra("Descripcion", descripcion.getText().toString());
                i.putExtra("Fecha", eTfecha.getText().toString());
                startActivity(i);


            }
        });

        String nombreConfirmacion = getIntent().getStringExtra( "NombreConfirmacion" );
        String telefonoConfirmacion = getIntent().getStringExtra("TelefonoConfirmacion");
        String emailConfirmacion = getIntent().getStringExtra("EmailConfirmacion");
        String descripcionConfirmacion = getIntent().getStringExtra("DescripcionConfirmacion");
        String fechaConfirmacion = getIntent().getStringExtra("FechaConfirmacion");

        nombre.setText(nombreConfirmacion);
        telefono.setText(telefonoConfirmacion);
        email.setText(emailConfirmacion);
        descripcion.setText(descripcionConfirmacion);
        eTfecha.setText(fechaConfirmacion);

    }



 /*   public void fecha(View view) {
        Calendar calendario = Calendar.getInstance();
        int a = calendario.get(Calendar.YEAR);
        int m = calendario.get(Calendar.MONTH);
        int d = calendario.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dateP = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String fecha = dayOfMonth +"/" + month + "/" + year;
                eTfecha.setText(fecha);

            }
        },a,m,d);

        dateP.show();
    }
*/

}