package com.phikapdev.springbootjpa.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.phikapdev.springbootjpa.models.entity.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
    public Usuario findByUsername(String username);
}
