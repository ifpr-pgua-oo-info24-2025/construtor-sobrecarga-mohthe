class Carro{

    private String placa;
    private String modelo;
    private String marca;
    private Condutor condutor;
    private Motor motor;

    
    public Carro(String placa, String marca, String modelo, Condutor condutor, Motor motor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.condutor = condutor;
        this.motor = motor;
    }

    public String getPlaca(){
        return placa;
    }
    public void setPlaca(String novaPlaca){
        this.placa = novaPlaca;
    }

    public String getModelo(){
        return modelo;
    }
    public void setModelo(String novoModelo){
        this.modelo = novoModelo;
    }
    
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public String toString(){
        return "1- Placa:" + this.placa +
        "\n" + "2- Modelo:" + this.modelo + 
        "\n" + "3- Marca:" + this.marca + 
        "\n" + (this.condutor != null ? condutor.toString() : "4- Condutor: Não definido") +
        "\n" + (this.motor != null ? motor.toString() : "5- Motor: Não definido");
    }
}