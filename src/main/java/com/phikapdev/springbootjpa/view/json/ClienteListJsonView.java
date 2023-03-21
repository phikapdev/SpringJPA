package com.phikapdev.springbootjpa.view.json;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.phikapdev.springbootjpa.models.entity.Cliente;
import com.phikapdev.springbootjpa.view.xml.ClienteList;

@Component("listar.json")
public class ClienteListJsonView extends MappingJackson2JsonView{

    @Override
    protected Object filterModel(Map<String, Object> model) {
        
        model.remove("titulo");
        model.remove("page");

        Page<Cliente> clientes = (Page<Cliente>) model.get("clientes");

        model.remove("clientes");
        model.put("clientes", new ClienteList(clientes.getContent()));


        return super.filterModel(model);
    }
    
}
