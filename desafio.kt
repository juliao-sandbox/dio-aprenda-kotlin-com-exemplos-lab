// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun inscrever(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} inscrito na Formação de $nome")
        } else {
            println("Erro: O usuário ${usuario.nome} já estava inscrito na Formação de $nome")
        }
    }

    fun desinscrever(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            inscritos.remove(usuario)
            println("Usuário ${usuario.nome} desinscrito da Formação de $nome")
        } else {
            println("Erro: O usuário ${usuario.nome} não está inscrito na Formação de $nome")
        }
    }

    fun exibirUsuariosInscritos() {
        println("Há ${inscritos.size} usuários inscritos na Formação de $nome (Nível: $nivel):")
        for (i in 0 until inscritos.size) {
            println("${i+1} - ${inscritos[i].nome}")
        }
    }
}

fun main() {
    val conteudosFormacaoLinux = listOf<ConteudoEducacional>(
        ConteudoEducacional("Terminal", 60),
        ConteudoEducacional("Shell Script", 120),
        ConteudoEducacional("Gerenciador de pacotes", 120)
    )

    val conteudosFormacaoKotlin = listOf<ConteudoEducacional>(
        ConteudoEducacional("Variáveis", 60),
        ConteudoEducacional("Classes", 120),
        ConteudoEducacional("Coroutines", 120)
    )

    val formacao1 = Formacao("Linux", Nivel.BASICO , conteudosFormacaoLinux)
    val formacao2 = Formacao("Kotlin", Nivel.INTERMEDIARIO, conteudosFormacaoKotlin)

    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")
    val usuario3 = Usuario("Pedro")
    val usuario4 = Usuario("Joana")
    val usuario5 = Usuario("Paulo")
    val usuario6 = Usuario("Fernanda")

    formacao1.inscrever(usuario1)
    formacao1.inscrever(usuario2)
    formacao1.inscrever(usuario1)
    formacao1.desinscrever(usuario1)
    println()
    
    formacao1.exibirUsuariosInscritos()
    println()

    formacao2.inscrever(usuario1)
    formacao2.inscrever(usuario2)
    formacao2.inscrever(usuario3)
    formacao2.inscrever(usuario4)
    formacao2.inscrever(usuario5)
    formacao2.inscrever(usuario6)
    println()

    formacao2.exibirUsuariosInscritos()
}
