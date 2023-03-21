package com.phikapdev.springbootjpa.util.paginator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;

public class PageRender<T> {

    private String url;
    private Page<T> page;

    private int totalPaginas;

    private int numElementosPorPaginas;

    private int paginaActual;

    private List<PageItem> paginas;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        numElementosPorPaginas = page.getSize();
        this.paginas = new ArrayList<PageItem>();

        totalPaginas = page.getTotalPages();
        paginaActual = page.getNumber();

        int desde, hasta;
        if(totalPaginas <= numElementosPorPaginas){
            desde = 1;
            hasta = totalPaginas;
        }else{
            if(paginaActual <= numElementosPorPaginas / 2){
                desde = 1; 
                hasta = numElementosPorPaginas;
            }else if(paginaActual >= totalPaginas - numElementosPorPaginas/2){
                desde = totalPaginas - numElementosPorPaginas + 1;
                hasta = numElementosPorPaginas;
            }else {
                desde = paginaActual - numElementosPorPaginas/2;
                hasta = numElementosPorPaginas;
            }
        }

        for(int i = 0; i < hasta; i++ ){
            paginas.add(new PageItem(desde + i, paginaActual == desde + i));
        }

    }

    public String getUrl() {
        return url;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public List<PageItem> getPaginas() {
        return paginas;
    }

    public boolean isFirst(){
        return page.isFirst();
    }

    public boolean isLast(){
        return page.isLast();
    }
    
    public boolean isHasNext(){
        return page.hasNext();
    }

    public boolean isHasPrevious(){
        return page.hasPrevious();
    }

}
