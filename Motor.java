class Motor{
    
    private String tipo;
    private Integer potencia;
    
    public Motor(String tipo, Integer potencia) {
        this.tipo = tipo;
        this.potencia = potencia;
    }

    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public Integer getPotencia(){
        return potencia;
    }
    public void setPotencia(Integer potencia){
        this.potencia = potencia;
    }

    public String toString(){
        return "5- Tipo: " + this.tipo + 
        " / Potencia: " + this.potencia;
    }
}