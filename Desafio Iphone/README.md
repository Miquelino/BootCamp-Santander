# BootCamp-Santander

Desafio Iphone

classDiagram
    Main <|-- Principal
    Principal <|-- AparelhoTelefonico
    Principal <|-- navegadorDeInternet
    Principal <|-- ReprodutorMusical
    class Principal{
      +exibirMenu()
    }
    class AparelhoTelefonico{
      +boolean ligando
      +ligar()
      +atender()
      +desligar()
      +iniciarCorreioVoz()
    }
    class navegadorDeInternet{
      -int qtdAba
      +exibirPagina()
      +adicionarNovaAba()
      +atualizarPagina()
      +fecharPagina()
    }
    class ReprodutorMusical{
      -boolean tocando
      +tocar()
      +pausar()
      +selecionarMusica()
    }


