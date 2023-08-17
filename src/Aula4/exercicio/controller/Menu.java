package Aula4.exercicio.controller;

import Aula4.exercicio.entity.Pedido;
import Aula4.exercicio.entity.Prato;
import Aula4.exercicio.entity.Cliente;
import Aula4.exercicio.entity.Restaurante;
import Aula4.exercicio.repository.ClienteRepositorio;
import Aula4.exercicio.service.ClienteService;
import Aula4.exercicio.service.RestauranteService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Menu {

    private RestauranteService restauranteService;
    private ClienteService clienteService;
    private ClienteRepositorio clienteRepositorio;
    private Scanner sc;

    public Menu(RestauranteService restauranteService, ClienteService clienteService, ClienteRepositorio clienteRepositorio){
        this.restauranteService = restauranteService;
        this.clienteService = clienteService;
        this.clienteRepositorio = clienteRepositorio;
        this.sc = new Scanner(System.in);
    }

    public void exibirMenu() {
        while (true) {
            int opcao;
            System.out.println("Sistema de Pedidos de Restaurantes");
            System.out.println("1. Cadastrar restaurante");
            System.out.println("2. Listar restaurantes");
            System.out.println("3. Adicionar prato");
            System.out.println("4. Visualizar pratos de um restaurante");
            System.out.println("5. Fazer um pedido");
            System.out.println("6. Visualizar pedidos de um restaurante");
            System.out.println("7. Visualizar pedidos de um cliente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Por favor, insira um número para operação que deseja realizar.");
                sc.nextLine();
                continue;
            }
            switch (opcao) {
                case 1:
                    cadastrarRestaurante();
                    break;
                case 2:
                    listarRestaurantes();
                    break;
                case 3:
                    adicionarPrato();
                    break;
                case 4:
                    listarPratosRestaurante();
                    break;
                case 5:
                    fazerPedido();
                    break;
                case 6:
                    listarPedidosRestaurante();
                    break;
                case 7:
                    verPedidosCliente();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarRestaurante() {
        System.out.print("Informe o nome do restaurante: ");
        String nome = sc.nextLine();

        System.out.print("Informe o endereço do restaurante: ");
        String endereco = sc.nextLine();

        Restaurante restaurante = new Restaurante(nome, endereco);
        restauranteService.cadastrarRestaurante(restaurante);

        System.out.println("Restaurante cadastrado.!");
    }

    private void listarRestaurantes() {
        List<Restaurante> restaurantes = restauranteService.listarRestaurante();

        if (restaurantes.isEmpty()) {
            System.out.println("Nenhum restaurante foi cadastrado.");
        }
        else {
            for (Restaurante restaurante : restaurantes) {
                System.out.println(restaurante);
            }
        }
    }

    private void adicionarPrato() {
        System.out.print("Id do Restaurante: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome do restaurante: ");
        String nomeRest = sc.nextLine();

        System.out.print("Nome do prato: ");
        String nomePrato = sc.nextLine();

        System.out.print("Preço do prato: ");
        Double preco = sc.nextDouble();
        sc.nextLine();

        System.out.print("Descrição do Prato: ");
        String descricao = sc.nextLine();

        Prato prato = new Prato(nomePrato, preco, descricao);
        restauranteService.adicionarPrato(id, nomePrato, prato);
        System.out.println("Prato adicionado com sucesso!");
    }

    private void listarPratosRestaurante() {
        System.out.print("Id do restaurante: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome do restaurante: ");
        String nomeRest = sc.nextLine();

        List<Prato> pratos = restauranteService.listarPratos(id, nomeRest);

        if (pratos == null || pratos.isEmpty()) {
            System.out.println("Nenhum prato disponível.");
        }
        else {
            for (Prato prato : pratos) {
                System.out.println(prato);
            }
        }
    }

    private void fazerPedido() {
        System.out.print("O cliente que deseja realizar o pedido já esta cadastrado? (S/N): ");
        String opcao = sc.nextLine();
        Cliente cliente = null;

        if (opcao.equalsIgnoreCase("S")) {
            System.out.print("Id do cliente: ");
            int idCliente = sc.nextInt();
            sc.nextLine();

            System.out.print("Nome do cliente: ");
            String nomeCliente = sc.nextLine();

            cliente = clienteRepositorio.buscarPrato(idCliente, nomeCliente);
            if (cliente == null) {
                System.out.println("Cliente não encontrado!");
                return;
            }
        }
        else {
            System.out.print("Deseja cadastrar um novo cliente com este pedido? (S/N): ");
            opcao = sc.nextLine();
            if (opcao.equalsIgnoreCase("S")) {
                System.out.print("Informe o nome do cliente: ");
                String nomeCliente = sc.nextLine();
                cliente = new Cliente(nomeCliente);
                clienteRepositorio.addCliente(cliente);
                System.out.println("Cliente cadastrado.");
            }
            else {
                return;
            }
        }
        System.out.print("Id do restaurante: ");
        int idRest = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome do restaurante: ");
        String nomeRest = sc.nextLine();
        List<Prato> pratos = new ArrayList<>();

        while (true) {
            System.out.println("1. Adicionar prato ao pedido");
            System.out.println("0. Finalizar Pedido");
            System.out.print("Escolha uma opção: ");
            int opcaoPrato = sc.nextInt();
            sc.nextLine();

            if (opcaoPrato == 1) {
                System.out.print("Identificador do prato: ");
                Integer identificadorPrato = sc.nextInt();
                sc.nextLine();
                System.out.print("Nome do prato: ");
                String nomePrato = sc.nextLine();

                List<Prato> pratosRestaurante = restauranteService.listarPratos(idRest, nomeRest);
                for (Prato prato : pratosRestaurante) {
                    if (prato.getIdentificador().equals(identificadorPrato)) {
                        pratos.add(prato);
                    }
                }
            }
            else if (opcaoPrato == 0) {
                break;
            }
            else {
                System.out.println("Opção inválida!");
            }
        }
        clienteService.fazerPedido(cliente.getIdentificador(), cliente.getNome(), idRest,
                nomeRest, pratos);
        System.out.println("Pedido realizado.");
    }


    private void listarPedidosRestaurante() {
        System.out.print("Id do restaurante: ");
        int idRest = sc.nextInt();
        sc.nextLine();

        System.out.print("Nome do restaurante: ");
        String nomeRest = sc.nextLine();
        List<Pedido> pedidos = restauranteService.listarPedidosRest(idRest, nomeRest);

        if (pedidos == null || pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado.");
        }
        else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }

    private void verPedidosCliente() {
        System.out.print("Id do Cliente: ");
        int idCliente = sc.nextInt();
        sc.nextLine();
        System.out.print("Nome do Cliente: ");
        String nomeCliente = sc.nextLine();
        List<Pedido> pedidos = clienteService.pedidosCliente(idCliente, nomeCliente);

        if (pedidos == null || pedidos.isEmpty()) {
            System.out.println("Nenhum pedido encontrado para o cliente.");
        }
        else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
                System.out.println();
            }
        }
    }
}

