package com.example.hotelitoreservacionfacilito;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.hotelitoreservacionfacilito.app.administrador.MenuPrincipalAdministrador;
import com.example.hotelitoreservacionfacilito.app.administrador.PrincipalAdministrador;
import com.example.hotelitoreservacionfacilito.app.cliente.MenuPrincipalCliente;
import com.example.hotelitoreservacionfacilito.app.cliente.PrincipalCliente;
import com.example.hotelitoreservacionfacilito.app.recepcionista.PrincipalRecepcionista;
import com.example.hotelitoreservacionfacilito.entities.RespuestaGenerica;
import com.example.hotelitoreservacionfacilito.models.Cliente;
import com.example.hotelitoreservacionfacilito.models.UsuarioEmpleado;
import com.example.hotelitoreservacionfacilito.service.ClienteService;
import com.example.hotelitoreservacionfacilito.service.RespuestaGenericaService;
import com.example.hotelitoreservacionfacilito.service.UsuarioEmpleadoService;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {

    String usuario = "";
    String clave = "";

    Button btn_ir_crearCuenta,iniciar_sesion,Imgmail,Imgfacebook;
    EditText edtCorreo, edtClave;

    Acceder acceder = new Acceder();
    LoginEmpleado loginEmpleado = new LoginEmpleado();
    LoginCliente loginCliente = new LoginCliente();
    RespuestaGenericaLogin respuestaGenericaLogin = new RespuestaGenericaLogin();
    UsuarioEmpleadoIniciado usuarioEmpleadoIniciado = new UsuarioEmpleadoIniciado();
    ClienteIniciado clienteIniciado = new ClienteIniciado();

    //Variable de Autentificacion
    GoogleSignInClient mGoogleSignInClient;
    int RC_SIGN_IN=0;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_ir_crearCuenta=findViewById(R.id.btn_ir_crearCuenta);
        iniciar_sesion=findViewById(R.id.iniciar_sesion);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtClave = findViewById(R.id.edtClave);
        Imgmail = findViewById(R.id.imgengmail);

        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Login.this, "Cargando ", Toast.LENGTH_SHORT).show();
                if (validUserAndPass()) {
                    //Toast.makeText(Login.this, "Asyntask ", Toast.LENGTH_SHORT).show();
                    reiniciarAsynkProcess();
                    respuestaGenericaLogin.execute();
                    System.out.println(Logued.usuarioEmpleadoListLogued);
                    System.out.println(Logued.clienteListLogued);

                }
            }
        });

        btn_ir_crearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Registrarse.class));

            }
        });

        //Registrar si no hay cuenta en la App con Gmail
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        Imgmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.imgengmail:
                        signIn();
                        break;
                    // ...
                }
            }
        });


    }

    //Metodos de login Con Gmail
    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            // Signed in successfully, show authenticated UI.
            Intent i = new Intent(getApplicationContext(), MenuPrincipalCliente.class);
            startActivity(i);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Error", "signInResult:failed code=" + e.getStatusCode());

        }
    }
    /*
    @Override
    protected void onStart() {
        super.onStart();

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
    }*/

    /* ------------FIN DE los metodos GMAIL------------- */

    public boolean isNetActive() {
        boolean c = false;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                c = true;
            }
        } catch (Exception e) {
            Log.e("error", "" + "error al comprobar conexion");
            Log.e("error", "" + e);
            c = false;
        }
        return c;
    }

    public boolean validUserAndPass() {
        boolean b = false;
        usuario = edtCorreo.getText().toString().trim();
        clave = edtClave.getText().toString().trim();
        try {
            if ("".equals(usuario)) {
                //Toast.makeText(Logon.this, "Igrese usuario", Toast.LENGTH_LONG).show();
                edtCorreo.setError("Ingrese usuario");
                return false;
            }
            if ("".equals(clave)) {
                //Toast.makeText(Logon.this, "Igrese contraseña", Toast.LENGTH_LONG).show();
                edtCorreo.setError("Ingrese contraseña");
                return false;
            }
            return true;
        } catch (Exception e) {
        }
        return b;
    }

    public void limpiar() {
        edtCorreo.setText("");
        edtClave.setText("");
    }

    public void reiniciarAsynkProcess() {
        acceder.cancel(true);
        acceder = new Acceder();

        loginEmpleado.cancel(true);
        loginEmpleado = new LoginEmpleado();

        loginCliente.cancel(true);
        loginCliente = new LoginCliente();

        respuestaGenericaLogin.cancel(true);
        respuestaGenericaLogin = new RespuestaGenericaLogin();

        usuarioEmpleadoIniciado.cancel(true);
        usuarioEmpleadoIniciado = new UsuarioEmpleadoIniciado();

        clienteIniciado.cancel(true);
        clienteIniciado = new ClienteIniciado();
    }

    public class Acceder extends AsyncTask<String, String, Integer> {


        @Override
        protected Integer doInBackground(String... strings) {
            int v = 0;

            try {
                if (isNetActive()) {
                    //System.out.println("comienza a leer vistas");
                    UsuarioEmpleado userE = new UsuarioEmpleado();
                    userE.setUsuario(usuario);
                    userE.setClave(clave);

                    UsuarioEmpleadoService usuarioEmpleadoService = new UsuarioEmpleadoService();
                    v = usuarioEmpleadoService.signIn(userE);

                    if (v > 0){
                        userE = usuarioEmpleadoService.obtenerUsuarioEmpleadoPorId(v);
                    }
                    Logued.usuarioEmpleadoLogued = userE;
                }
            } catch (Exception ex) {
                System.out.println("*** errrr***: " + ex);
                ex.printStackTrace();
            }
            return v;
        }


        @Override
        protected void onPostExecute(Integer res) {
            super.onPostExecute(res);
            try {
                switch (res) {
                    case 0:
                        Toast.makeText(Login.this, "Error de servidor", Toast.LENGTH_LONG).show();
                        /*AlertDialog dialog = new AlertDialog.Builder(Login.this)
                                .setView(R.layout.dialog_server_err)
                                .setCancelable(true)
                                .setPositiveButton("Ok", null)
                                .show();*/
                        break;
                    case -1:
                        Toast.makeText(Login.this, "Error de Username", Toast.LENGTH_LONG).show();
                        /* dialog1 = new AlertDialog.Builder(Login.this)
                                .setView(R.layout.dialog_user_err)
                                .setCancelable(true)
                                .setPositiveButton("Ok", null)
                                .show();*/
                        break;
                    case -2:
                        Toast.makeText(Login.this, "Error de Password", Toast.LENGTH_LONG).show();
                        /*AlertDialog dialog2 = new AlertDialog.Builder(Login.this)
                                .setView(R.layout.dialog_pass_err)
                                .setCancelable(true)
                                .setPositiveButton("Ok", null)
                                .show();*/
                        break;
                    case -4:
                        Toast.makeText(Login.this, "Usuario Inactivo", Toast.LENGTH_LONG).show();
                        break;
                }
                if (res > 0){
                    Intent intent = new Intent(Login.this, PrincipalAdministrador.class);
                    startActivity(intent);
                }
                Toast.makeText(Login.this, "Limpiando", Toast.LENGTH_LONG).show();
                limpiar();
                reiniciarAsynkProcess();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }


    public class LoginEmpleado extends AsyncTask<String, String, List<UsuarioEmpleado>> {


        @Override
        protected List<UsuarioEmpleado> doInBackground(String... strings) {
            List<UsuarioEmpleado> usuarioEmpleadoList = new ArrayList<>();
            try {
                UsuarioEmpleadoService usuarioEmpleadoService = new UsuarioEmpleadoService();
                usuarioEmpleadoList = usuarioEmpleadoService.loginEmpleado(usuario, clave);

                //Toast.makeText(getApplicationContext(), "Este usuario no existe en la base de datos" , Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                System.out.println("Error en loginEmpleado: " +e.getMessage() +" " +e.getClass());
            }
            return usuarioEmpleadoList;
        }


        @Override
        protected void onPostExecute(List<UsuarioEmpleado> usuarioEmpleadoList) {
            super.onPostExecute(usuarioEmpleadoList);
            try {
                //Logued.usuarioEmpleadoListLogued = usuarioEmpleadoList;
                if(usuarioEmpleadoList.size() != 0){
                    if(usuarioEmpleadoList.get(0).getPersonal().getRol().getId_rol() == 1){
                        Toast.makeText(getApplicationContext(), "Bienvenido Administrador" , Toast.LENGTH_SHORT).show();
                    }else if(usuarioEmpleadoList.get(0).getPersonal().getRol().getId_rol() == 2){
                        Toast.makeText(getApplicationContext(), "Bienvenido Recepcionista" , Toast.LENGTH_SHORT).show();
                    }else if(usuarioEmpleadoList.get(0).getPersonal().getRol().getId_rol() == 3){
                        Toast.makeText(getApplicationContext(), "Bienvenido Auxiliar" , Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Este usuario no existe en la base de datos" , Toast.LENGTH_SHORT).show();
                    }
                }
                reiniciarAsynkProcess();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }

    public class LoginCliente extends AsyncTask<String, String, List<Cliente>> {


        @Override
        protected List<Cliente> doInBackground(String... strings) {
            List<Cliente> usuarioClientelList = new ArrayList<>();
            loginEmpleado.cancel(true);
            try {
                ClienteService clienteService = new ClienteService();
                usuarioClientelList = clienteService.loginCliente(usuario, clave);

                //reiniciarAsynkProcess();
            }catch (Exception e){
                System.out.println("Error en loginCliente: " +e.getMessage() +" " +e.getClass());
            }
            return usuarioClientelList;
        }


        @Override
        protected void onPostExecute(List<Cliente> usuarioClienteList) {
            super.onPostExecute(usuarioClienteList);
            try {
                if(usuarioClienteList.size() == 0){
                    Toast.makeText(getApplicationContext(), "Este usuario no existe en la base de datos" , Toast.LENGTH_SHORT).show();
                    reiniciarAsynkProcess();
                } else{
                    Toast.makeText(getApplicationContext(), "Bienvenido Cliente" , Toast.LENGTH_SHORT).show();
                }
                reiniciarAsynkProcess();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }

    public class RespuestaGenericaLogin extends AsyncTask<String, String, List<RespuestaGenerica>> {


        @Override
        protected List<RespuestaGenerica> doInBackground(String... strings) {
            List<RespuestaGenerica> respuestaList = new ArrayList<>();
            try {
                RespuestaGenericaService respuestaGenericaService = new RespuestaGenericaService();
                respuestaList = respuestaGenericaService.loginRespuestaGenerica(usuario, clave);
            }catch (Exception e){
                System.out.println("Error en RespuestaGeneticaLogin doIBack: " +e.getMessage() +" " +e.getClass());
            }
            return respuestaList;
        }


        @Override
        protected void onPostExecute(List<RespuestaGenerica> respuestaList) {
            super.onPostExecute(respuestaList);
            try {
                //Logued.usuarioEmpleadoListLogued = usuarioEmpleadoList;
                //Logued.respuestaGeneticaListLogued = respuestaList;
                if(respuestaList != null){
                    Logued.respuestaGeneticaListLogued = respuestaList;
                    int res = Integer.parseInt(respuestaList.get(0).getCodigo());
                    if(res == 0){
                        Toast.makeText(getApplicationContext(), "Este usuario no existe en la base de datos" , Toast.LENGTH_SHORT).show();
                    }else if(res == 4){
                        clienteIniciado.execute();
                    }else if(res < 4){
                        usuarioEmpleadoIniciado.execute();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Lista Vacia" , Toast.LENGTH_SHORT).show();
                }
                //reiniciarAsynkProcess();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }

    public class UsuarioEmpleadoIniciado extends AsyncTask<String, String, UsuarioEmpleado> {
        @Override
        protected UsuarioEmpleado doInBackground(String... strings) {
            List<RespuestaGenerica> respuestaList = new ArrayList<>();
            UsuarioEmpleado usuarioEmpleado = new UsuarioEmpleado();
            try {
                UsuarioEmpleadoService usuarioEmpleadoService = new UsuarioEmpleadoService();
                usuarioEmpleado = usuarioEmpleadoService.obtenerUsuarioEmpleadoPorId(Integer.parseInt(Logued.respuestaGeneticaListLogued.get(0).getMensaje()));
            }catch (Exception e){
                System.out.println("Error en UsuarioEmpleadoIniciado: " +e.getMessage() +" " +e.getClass());
            }
            return usuarioEmpleado;
        }


        @Override
        protected void onPostExecute(UsuarioEmpleado usuarioEmpleado) {
            super.onPostExecute(usuarioEmpleado);
            try {

                if(usuarioEmpleado.getPersonal().getRol().getId_rol() == 1){
                    Intent i = new Intent(getApplicationContext(), MenuPrincipalAdministrador.class);
                    startActivity(i);
                }else if(usuarioEmpleado.getPersonal().getRol().getId_rol() == 2){
                    Intent i = new Intent(getApplicationContext(), PrincipalRecepcionista.class);
                    startActivity(i);
                }
                Logued.usuarioEmpleadoLogued = usuarioEmpleado;
                System.out.println(Logued.usuarioEmpleadoLogued.toString());
                //reiniciarAsynkProcess();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }

    public class ClienteIniciado extends AsyncTask<String, String, Cliente> {
        @Override
        protected Cliente doInBackground(String... strings) {
            List<RespuestaGenerica> respuestaList = new ArrayList<>();
            Cliente cliente = new Cliente();
            try {
                ClienteService clienteService = new ClienteService();
                cliente = clienteService.obtenerClientePorId(Integer.parseInt(Logued.respuestaGeneticaListLogued.get(0).getMensaje()));
            }catch (Exception e){
                System.out.println("Error en ClienteIniciado: " +e.getMessage() +" " +e.getClass());
            }
            return cliente;
        }


        @Override
        protected void onPostExecute(Cliente cliente) {
            super.onPostExecute(cliente);
            try {
                Intent i = new Intent(getApplicationContext(), MenuPrincipalCliente.class);
                startActivity(i);
                Logued.clienteLogued = cliente;
                //reiniciarAsynkProcess();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
    }

}
