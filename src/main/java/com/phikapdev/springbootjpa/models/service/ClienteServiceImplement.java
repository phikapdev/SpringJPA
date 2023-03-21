package com.phikapdev.springbootjpa.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phikapdev.springbootjpa.models.dao.IClienteDao;
import com.phikapdev.springbootjpa.models.dao.IFacturaDao;
import com.phikapdev.springbootjpa.models.dao.IProductoDao;
import com.phikapdev.springbootjpa.models.entity.Cliente;
import com.phikapdev.springbootjpa.models.entity.Factura;
import com.phikapdev.springbootjpa.models.entity.Producto;

@Service
public class ClienteServiceImplement implements IClienteService{

    @Autowired
    private IClienteDao clienteDao;

    @Autowired
    private IProductoDao productoDao;

    @Autowired
    private IFacturaDao facturaDao;

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);  
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findOne(Long id) {
       return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente fetchByIdWithFacturas(Long id) {
        return clienteDao.fetchByIdWithFacturas(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByNombre(String term) {
        
        return productoDao.findByNombre("%"+term+"%");
    }

    @Override
    @Transactional
    public void saveFactura(Factura factura) {
        facturaDao.save(factura);     
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findProductoById(Long id) {
        return productoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturaById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteFactura(Long id) {
        facturaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura fetchByIdWithClienteWithItemsFacturaWithProducto(Long id) {
        
        return facturaDao.fetchByIdWithClienteWithItemsFacturaWithProducto(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }
    
}
