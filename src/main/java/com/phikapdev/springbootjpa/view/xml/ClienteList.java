package com.phikapdev.springbootjpa.view.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.phikapdev.springbootjpa.models.entity.Cliente;

@XmlRootElement(name = "clientes")
public class ClienteList {

    @XmlElement
    public List<Cliente> clientes;

    public ClienteList() {
    }

    public ClienteList(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    
}
