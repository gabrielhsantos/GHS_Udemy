package visao

import modelo.Tabuleiro
import modelo.TabuleiroEvento
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities


    fun main(args: Array<String>) {
        TelaPrincipal()
    }

    class TelaPrincipal : JFrame() {

        private val tabuleiro = Tabuleiro(16, 30, 10)
        private val painelTabuleiro = PainelTabuleiro(tabuleiro)

        init {
            tabuleiro.onEvento(this::mostrarResultado)
            add(painelTabuleiro)

            setSize(690, 438)
            setLocationRelativeTo(null)
            defaultCloseOperation = EXIT_ON_CLOSE
            title = "CAMPO MINADO"
            isVisible = true
        }

        private fun mostrarResultado(evento: TabuleiroEvento) {
            SwingUtilities.invokeLater {
                val msg = when (evento) {
                    TabuleiroEvento.VITORIA -> "Você Ganhou!!!"
                    TabuleiroEvento.DERROTA -> "Você Perdeu!!!"
                }

                JOptionPane.showMessageDialog(this, msg)
                tabuleiro.reiniciar()

                painelTabuleiro.repaint()
                painelTabuleiro.validate()
            }
        }
    }
