package com.latencia.latencia.controllers;

import org.springframework.web.bind.annotation.RequestParam;




import com.latencia.latencia.models.Cliente;
import com.latencia.latencia.service.ClienteService;
import com.latencia.latencia.service.MessageVerifyService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate ;

    public ClienteController(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }


    @GetMapping("/cliente/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clienteNuevo";
    }

    
    @PostMapping("/cliente/new/save")
    public String usuarioGuardar(@ModelAttribute Cliente cliente) {

        clienteService.crearCliente(cliente);;
        return "redirect:/cliente";
    }
    

    @GetMapping("/cliente/mensaje")
    public String mensajeOTP() {
        return "mensajeForm";
    }

    @PostMapping("/cliente/mensaje/enviar")
    public String mensajeOTPEnviar(@RequestParam("phoneNumber") String telefono) {
        kafkaTemplate.send("mensaje",telefono);
        
        return "verify" ;
    }

    @PostMapping("/cliente/mensaje/verificar")
    public String mensajeOTPVerificar(@RequestParam("numberVerify") String numero, @RequestParam("telefono") String telefono) {
        MessageVerifyService messageVerifyService = new MessageVerifyService();

        String status = messageVerifyService.verificar(numero,telefono);

        if (status.equals("approved")){
            return "verifySuccess";
        }
        else {
            return "verifyFailed" ;
        }
    }
    

    @GetMapping("/cliente")
    public String darTodosLosClientes( Model model) {
        List<Cliente> clientes = clienteService.darTodosLosClientes();
      
        model.addAttribute("clientes", clientes);

        return "clientes";
    }

    
}
