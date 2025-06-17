package com.example.javalin.presentacion;

import com.example.javalin.modelo.Dueño;
import com.example.javalin.persistencia.RepositorioDueños;
import com.example.javalin.presentacion.dto.LoginRequest;
import com.example.javalin.presentacion.dto.LoginResponse;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class LoginHandler implements Handler {

    private final RepositorioDueños repoDueños;

    public LoginHandler() {
        this.repoDueños = new RepositorioDueños();
    }

    @Override
    public void handle(@NotNull Context context) throws Exception {
        //validamos user/pass y buscamos datos de ese usuario para agregar en la sesión

        LoginRequest loginRequest = context.bodyAsClass(LoginRequest.class);

        /*System.out.println(loginRequest.getUsername());
        System.out.println(loginRequest.getPassword());*/

        if (loginRequest.getUsername() == null || loginRequest.getPassword() == null ) {
            context.status(400).result("Faltan el nombre de usuario o la contraseña");
            return;
        }

        Dueño dueño = repoDueños.obtenerPersona(loginRequest.getUsername(),loginRequest.getPassword()); //hardcode: siempre loguea a Jose
        System.out.println("Login: " + loginRequest);
        System.out.println("Login: " + dueño);

        SesionManager sesionManager = SesionManager.get();
        String idSesion = sesionManager.crearSesion("dueño", dueño);

//        sesionManager.agregarAtributo(idSesion, "fechaInicio", new Date());
//        sesionManager.agregarAtributo(idSesion, "rol", repoRoles.getByUser(idUser));

        context.status(200).result("La sesion fue creada con exito");
        context.json(new LoginResponse(idSesion));

    }

}
