package com.br.indik.domain;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface AvaliacaoFilmeDao {
	@SqlQuery("SELECT A.id, A.texto, A.nota, B.titulo, B.ano, B.diretor, B.pais FROM avaliacao_filme as A INNER JOIN tb_filme as B ON A.filme_ref = B.id")
	@RegisterBeanMapper(Avaliacao.class)
	List<Avaliacao> readAvaFilme();
	
	@SqlQuery("SELECT * FROM tb_filme WHERE id=?")
	@RegisterBeanMapper(Filme.class)
	Filme readFilme(int id);
	
	/*@SqlUpdate("UPDATE avaliacao_filme SET nome=:nome, whats=:whats, tipo=:tipo, email=:email WHERE id=:id")
	void update(@BindBean Avaliacao l);
	*/
	
	@SqlUpdate("DELETE FROM avaliacao_filme WHERE id=?")
	void deleteAvaFilme(int id);
}
