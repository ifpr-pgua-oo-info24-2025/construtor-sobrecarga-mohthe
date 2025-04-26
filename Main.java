import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    static ArrayList<Carro> garagem = new ArrayList<Carro>();
    static ArrayList<Condutor> condutores = new ArrayList<Condutor>();
    static ArrayList<Motor> motores = new ArrayList<Motor>();

    public static void main(String[] args) {
        Boolean saida = false;
        Integer choice;
        Scanner scan = new Scanner(System.in);


        while(!saida){
            
            System.out.println("1- Adicionar");
            System.out.println("2- Alterar");
            System.out.println("3- Excluir");
            System.out.println("4- Dados");
            System.out.println("0- Sair");
            choice = scan.nextInt();

            clearScreen();

            switch(choice){
                case 1:
                    adicionar(scan);
                    break;

                case 2:
                    alterar(scan);
                    break;

                case 3:
                    excluir(scan);
                    break;

                case 4:     
                    dados(scan);              
                    break;

                case 0:
                    return;

                default:
                    break;
            }
        }
    }
    public static void adicionar(Scanner scan){
        Integer choice;
        clearScreen();
        
        System.out.println("O que deseja adicionar?");
        System.out.println("1- Carro");
        System.out.println("2- Condutor");
        System.out.println("3- Motor");
        System.out.println("0- Voltar");

        choice = scan.nextInt();
        scan.nextLine();

        switch(choice){
            case 1:
                adicionarCarro(scan);
                break;

            case 2:
                adicionarCondutor(scan);
                break;

            case 3:
                adicionarMotor(scan);
                break;

            default:
                break;
        }
    }

    public static void adicionarCarro(Scanner scan){
        String placa, marca, modelo;
        Integer auxInt;
        Condutor condutor = null;
        Motor motor = null;
        clearScreen();

        System.out.println("Placa do carro?");
        placa = scan.nextLine();
        
        System.out.println("Marca do carro?");
        marca = scan.nextLine();
        
        System.out.println("Modelo do carro?");
        modelo = scan.nextLine();
        
        System.out.println("Deseja adicionar um condutor?");
        System.out.println("1- Sim / 2- Não");
        auxInt = scan.nextInt();
        scan.nextLine();
        
        if(auxInt == 1){
            auxInt = 0;

            if(condutores.size() < 1){
                adicionarCondutor(scan);
            }
            
            while((auxInt < 1) || (auxInt > condutores.size())){
                clearScreen();
                
                System.out.println("Escolha:");
                for (Condutor iCondutor : condutores) {
                    auxInt++;
                    System.out.printf("%d- ", auxInt);
                    System.out.println(iCondutor.getNome());
                }
                auxInt = scan.nextInt();
            }
            auxInt--;
            condutor = condutores.get(auxInt);
        }

        System.out.println("Deseja adicionar um motor?");
        System.out.println("1- Sim / 2- Não");
        auxInt = scan.nextInt();
        scan.nextLine();

        if(auxInt == 1){
            auxInt = 0;

            if(motores.size() < 1){
                adicionarMotor(scan);
            }
            
            while((auxInt < 1) || (auxInt > motores.size())){
                clearScreen();

                System.out.println("Escolha:");
                auxInt++;
                for (Motor iMotor : motores) {
                    System.out.printf("%d- ", auxInt);
                    System.out.println(iMotor.getTipo() + "/ potencia: " + iMotor.getPotencia());
                }
                auxInt = scan.nextInt();
            }
            auxInt--;
            motor = motores.get(auxInt);
        }

        garagem.add(new Carro(placa, marca, modelo, condutor, motor));
    }

    public static void adicionarCondutor(Scanner scan){
        String nome, cnh;
        clearScreen();

        System.out.println("Digite o nome do condutor:");
        nome = scan.nextLine();

        System.out.println("Digite a cnh do condutor:");
        cnh = scan.nextLine();

        condutores.add(new Condutor(nome, cnh));
        
    }

    public static void adicionarMotor(Scanner scan){
        String tipo;
        Integer potencia;
        clearScreen();

        System.out.println("Digite tipo do motor:");
        tipo = scan.nextLine();

        System.out.println("Digite a potencia do motor:");
        potencia = scan.nextInt();
        scan.nextLine();

        motores.add(new Motor(tipo, potencia));
    }

    public static void alterar(Scanner scan){
        Integer choice;
        
        System.out.println("Escolha:");
        System.out.println("1- Carro");
        System.out.println("2- Condutor");
        System.out.println("3- Motor");
        System.out.println("0- Voltar");
        
        choice = scan.nextInt();
        clearScreen();

        switch(choice){
            case 1:
                alterarCarro(scan);
                break;

            case 2:
                alterarCondutor(scan);
                break;

            case 3:
                alterarMotor(scan);
                break;

            default:
                break;
        }
    }

    public static void alterarCarro(Scanner scan){
        Integer auxInt = 0;

        
        if(garagem.size() < 1){
            System.out.println("Voce nao tem carros cadastrados.");
            return;
        }

        while((auxInt < 1) || (auxInt > garagem.size())){
            clearScreen();
            auxInt++;

            System.out.println("Escolha:");
            for (Carro carro : garagem) {
                System.out.println(auxInt + "- " + carro.getMarca());
                System.out.println("   " + carro.getModelo() + "\n");
            }
            auxInt = scan.nextInt();
            scan.nextLine();
        }    
        auxInt--;
        alteracaoCarro(scan, auxInt);
    }

    public static void alteracaoCarro(Scanner scan, Integer index){
        Integer auxInt = 0;
        String auxStr;
        
        while((auxInt < 1) || (auxInt > 5)){
            clearScreen();

            System.out.println(garagem.get(index));
            System.out.println("0- Voltar\nO que deseja alterar?");
            
            auxInt = scan.nextInt();
            scan.nextLine();
        }

        clearScreen();
        switch(auxInt){
            case 1:
                System.out.println("Digite a nova placa:");
                auxStr = scan.nextLine();

                garagem.get(index).setPlaca(auxStr);
                break;
                
            case 2:
                System.out.println("Digite a nova marca:");
                auxStr = scan.nextLine();

                garagem.get(index).setMarca(auxStr);
                break;

            case 3:
                System.out.println("Digite o novo modelo:");
                auxStr = scan.nextLine();

                garagem.get(index).setModelo(auxStr);
                break;

            case 4:
                while((auxInt < 1) || (auxInt > condutores.size())){
                    clearScreen();

                    auxInt++;
                    System.out.println("Digite o novo condutor:");
                    for (Condutor condutor : condutores){
                        System.out.printf("%d- ", auxInt);
                        System.out.println(condutor.getNome());
                    }
                    auxInt = scan.nextInt();
                    scan.nextLine();

                    auxInt--;
                    garagem.get(index).setCondutor(condutores.get(auxInt));
                }
                break;

            case 5:
                while((auxInt < 1) || (auxInt > motores.size())){
                    clearScreen();

                    auxInt++;
                    System.out.println("Digite o novo motor:");
                    for (Motor motor : motores){
                        System.out.printf("%d- ", auxInt);
                        System.out.println(motor.getTipo() + "/ Potencia: " + motor.getPotencia());
                    }
                    auxInt = scan.nextInt();
                    scan.nextLine();

                    auxInt--;
                    garagem.get(index).setMotor(motores.get(auxInt));
                }
                break;
            
            default:
                return;
        }
    }

    public static void alterarCondutor(Scanner scan){
        Integer auxInt = 0;
        clearScreen();
        
        if(condutores.size() < 1){
            System.out.println("Voce nao tem condutores cadastrados.");
            return;
        }

        while((auxInt < 1) || (auxInt > condutores.size())){
            clearScreen();

            System.out.println("Escolha:");
            for (Condutor condutor : condutores) {
                System.out.println(condutor);
            }
            auxInt = scan.nextInt();
            scan.nextLine();
        }    
        auxInt--;
        alteracaoCondutor(scan, auxInt);
    }

    public static void alteracaoCondutor(Scanner scan, Integer index){
        Integer auxInt = 0;
        String auxStr;

        while((auxInt < 1) || (auxInt > 2)){
            clearScreen();

            System.out.println(condutores.get(index));
            System.out.println("0- Voltar\nO que deseja alterar?");
            
            auxInt = scan.nextInt();
            scan.nextLine();
        }

        clearScreen();
        switch(auxInt){
            case 1:
                System.out.println("Digite o novo nome:");
                auxStr = scan.nextLine();

                condutores.get(index).setNome(auxStr);
                break;

            case 2:
                System.out.println("Digite a nova cnh:");
                auxStr = scan.nextLine();

                condutores.get(index).setCnh(auxStr);
                break;

            default:
                return;
        }
    }

    public static void alterarMotor(Scanner scan){
        Integer auxInt = 0;
        
        if(motores.size() < 1){
            System.out.println("Voce nao tem motores cadastrados.");
            return;
        }

        while((auxInt < 1) || (auxInt > motores.size())){
            clearScreen();

            System.out.println("Escolha:");
            for (Motor motor : motores) {
                System.out.println(motor);
            }
            auxInt = scan.nextInt();
            scan.nextLine();
        }    
        auxInt--;
        alteracaoMotor(scan, auxInt);
    }

    public static void alteracaoMotor(Scanner scan, Integer index){
        Integer auxInt = 0;
        String auxStr;

        while((auxInt < 1) || (auxInt > 2)){
            clearScreen();

            System.out.println(motores.get(index));
            System.out.println("0- Voltar\nO que deseja alterar?");
            
            auxInt = scan.nextInt();
            scan.nextLine();
        }

        clearScreen();
        switch(auxInt){
            case 1:
                System.out.println("Digite o novo tipo:");
                auxStr = scan.nextLine();

                motores.get(index).setTipo(auxStr);
                break;

            case 2:
                System.out.println("Digite a nova potencia:");
                auxInt = scan.nextInt();
                scan.nextLine();

                motores.get(index).setPotencia(auxInt);
                break;

            default:
                return;
        }
    }

    public static void excluir(Scanner scan){
        Integer choice;

        System.out.println("Escolha:");
        System.out.println("1- Carro");
        System.out.println("2- Condutor");
        System.out.println("3- Motor");
        System.out.println("0- Voltar");
        
        choice = scan.nextInt();
        clearScreen();

        switch(choice){
            case 1:
                excluirCarro(scan);
                break;

            case 2:
                excluirCondutor(scan);
                break;

            case 3:
                excluirMotor(scan);
                break;

            default:
                break;
        }
    }

    public static void excluirCarro(Scanner scan){
        Integer auxInt = 0;

        if(garagem.size() < 1){
            System.out.println("Voce nao tem carros cadastrados.");
            return;
        }

        while((auxInt < 1) || (auxInt > garagem.size())){
            clearScreen();

            System.out.println("Escolha:");
            for (Carro carro : garagem) {
                System.out.println(carro);
            }
            auxInt = scan.nextInt();
            scan.nextLine();
        }    
        auxInt--;
        garagem.remove(garagem.get(auxInt));
    }

    public static void excluirCondutor(Scanner scan){
        Integer auxInt = 0;

        if(condutores.size() < 1){
            System.out.println("Voce nao tem condutores cadastrados.");
            return;
        }

        while((auxInt < 1) || (auxInt > condutores.size())){
            clearScreen();

            System.out.println("Escolha:");
            for (Condutor condutor: condutores) {
                System.out.println(condutor);
            }
            auxInt = scan.nextInt();
            scan.nextLine();
        }    
        auxInt--;

        checkCondutor(scan, auxInt);
        condutores.remove(condutores.get(auxInt));
    }

    public static void checkCondutor(Scanner scan, Integer index){
        for (Carro carro : garagem){
            if(carro.getCondutor() == condutores.get(index)){
                carro.setCondutor(null);
            }
        }
    }

    public static void excluirMotor(Scanner scan){
        Integer auxInt = 0;

        if(motores.size() < 1){
            System.out.println("Voce nao tem motores cadastrados.");
            return;
        }

        while((auxInt < 1) || (auxInt > motores.size())){
            clearScreen();

            System.out.println("Escolha:");
            for (Motor motor: motores) {
                System.out.println(motor);
            }
            auxInt = scan.nextInt();
            scan.nextLine();
        }    
        auxInt--;

        checkMotor(scan, auxInt);
        motores.remove(motores.get(auxInt));
    }

    public static void checkMotor(Scanner scan, Integer index){
        for (Carro carro : garagem){
            if(carro.getMotor() == motores.get(index)){
                carro.setMotor(null);
            }
        }
    }

    public static void dados(Scanner scan){
        clearScreen();

        for (Carro carros : garagem) {
            System.out.println(carros + "\n");
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}