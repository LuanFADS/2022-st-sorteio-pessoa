package br.edu.facec.sorteio.pessoa.entity

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.util.*

internal class PessoaTest {
    @Test
    internal fun nome_da_pessoa_nao_deve_ser_vazio() {
        assertThatThrownBy {
            Pessoa(
                UUID.randomUUID(),
                "",
                "44999999999",
                "umemail@gmail.com"
            )
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Nome da pessoa deve ser informado.")
    }

    @Test
    internal fun deve_possuir_o_id_igual_o_esperado() {
        val expectedId = UUID.randomUUID()

        val unit = Pessoa(
            id = expectedId,
            nome = "Fulano",
            telefone = "44988888888",
            email = "outroemail@gmail.com"
        )

        assertThat(unit.hasId(expectedId)).isTrue()
    }
}