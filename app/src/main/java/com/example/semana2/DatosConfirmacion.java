package com.example.semana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DatosConfirmacion extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_confirmacion);

        Bundle parametros = getIntent().getExtras();
        String nombre = parametros.getString("Nombre");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String descripcion = parametros.getString("Descripcion");
        String fecha = parametros.getString("Fecha");

        TextView tvnombre = (TextView) findViewById(R.id.confirmarNombre);
        TextView tvtelefono = (TextView) findViewById(R.id.confirmarTelefono);
        TextView tvemail = (TextView) findViewById(R.id.confirmarEmail);
        TextView tvdescripcion = (TextView) findViewById(R.id.confirmarDescripcion);
        TextView tvfecha = (TextView) findViewById(R.id.confirmarFechaNacimiento);

        tvnombre.setText("Nombre: " + nombre);
        tvtelefono.setText("Teléfono: " + telefono);
        tvemail.setText("Email: " + email);
        tvdescripcion.setText("Descripción: " + descripcion);
        tvfecha.setText("Fecha de nacimiento: " +fecha);


        Button botonAceptar = (Button) findViewById(R.id.botonConfirmar);
        botonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DatosConfirmacion.this,MainActivity.class);
                i.putExtra("NombreConfirmacion", nombre );
                i.putExtra("TelefonoConfirmacion", telefono );
                i.putExtra("EmailConfirmacion", email );
                i.putExtra("DescripcionConfirmacion", descripcion );
                i.putExtra("FechaConfirmacion", fecha);
                startActivity(i);
            }
        });


    }






}