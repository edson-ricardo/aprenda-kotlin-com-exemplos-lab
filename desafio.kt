/*
 Sistema modelado de um aluno do curso.
 Confesso que tentei fazer, mas não ficou muito legal.
 Modelei este abaixo e estudei cada código para entender o que estava acontecendo.
*/

data class Usuario(val nome: String, val CPF: String)

data class ConteudoEducacional(val nome: String, var nivel: Nivel, val duracao: Int)

enum class Nivel { Basico, Intermediario, Avancado }

data class Formacao(var nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun listaDeContatos() {
        for (usuario in inscritos) {
            println("Nome: ${usuario.nome} | CPF: ${usuario.CPF}")
        }
    }

    /*fun conteudoFormacao() {
        for (conteudo in conteudos) {
            println("${conteudo.nome} - ${conteudo.duracao}h")
        }
    }*/
}

fun main() {

    val financasConteudo = ConteudoEducacional("Finanças Pessoais", Nivel.Basico, 80)
    val inglesConteudo = ConteudoEducacional("Inglês", Nivel.Intermediario, 120)
    val KotlinConteudo = ConteudoEducacional("Desenvolvimento Kotlin", Nivel.Avancado, 100)
    val listaDeConteudo = mutableListOf<ConteudoEducacional>()
    listaDeConteudo.add(financasConteudo)
    listaDeConteudo.add(inglesConteudo)
    listaDeConteudo.add(KotlinConteudo)

    val financasFormacao = Formacao("Finanças Pessoais", listaDeConteudo)
    val inglesFormacao = Formacao("Inglês", listaDeConteudo)
    val KotlinFormacao = Formacao("Desenvolvimento Kotlin", listaDeConteudo)

    val usuario1 = Usuario("João", "087.387.987-87")
    val usuario2 = Usuario("Maria", "005.067.087-85")
    val usuario3 = Usuario("José", "040.040.036-20")
    val usuario4 = Usuario("Lúcia", "080.080.056-25")
    val usuario5 = Usuario("Jaime", "036.035.044-30")
    val usuario6 = Usuario("Josefa", "036.035.044-30")

    financasFormacao.matricular(usuario1)
    financasFormacao.matricular(usuario2)
    financasFormacao.matricular(usuario3)
    financasFormacao.matricular(usuario4)

    KotlinFormacao.matricular(usuario4)
    KotlinFormacao.matricular(usuario5)
    KotlinFormacao.matricular(usuario6)

    inglesFormacao.matricular(usuario1)
    inglesFormacao.matricular(usuario4)
    inglesFormacao.matricular(usuario6)

    println("DADOS DA FORMAÇÃO")
    println("------------------------------------------------------------------------------------")
    println("FORMAÇÕES:")
    for (conteudo in listaDeConteudo) {
        println("${conteudo.nome} - ${conteudo.duracao}h")
    }
    println("------------------------------------------------------------------------------------")

    println("Curso: ${financasConteudo.nome} | Nível: ${financasConteudo.nivel} |" +
            " Duração: ${financasConteudo.duracao}h")
    println("Aluno(s) cadastrado(s):")
    println("Nome: ${financasFormacao.listaDeContatos()}")
    println("------------------------------------------------------------------------------------")

    println("Curso: ${inglesConteudo.nome} | Nível: ${inglesConteudo.nivel} | Duração: ${inglesConteudo.duracao}h")
    println("Aluno(s) cadastrado(s):")
    println("Nome: ${inglesFormacao.listaDeContatos()}")
    println("------------------------------------------------------------------------------------")

    println("Curso: ${KotlinConteudo.nome} | Nível: ${KotlinConteudo.nivel} | Duração: ${KotlinConteudo.duracao}h")
    println("Aluno(s) cadastrado(s):")
    println("Nome: ${KotlinFormacao.listaDeContatos()}")
    println("------------------------------------------------------------------------------------")

}
