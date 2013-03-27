package gm.unb;

public class Predio {
	int id;
	int visitNumber;
	String nome;
	int estado;
	
	public Predio()
	{
		
	}
	
	public Predio(int id, int visitNumber, int state, String nome)
	{
		this.id = id;
		this.visitNumber = visitNumber;
		this.estado = state;
		this.nome = nome;
	}
	public int getEstate()
	{
		return estado;
	}
	
	public void setEstate(int estate)
	{
		this.estado = estate;
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getVisitNumber()
	{
		return visitNumber;
	}
	
	public void setVisitNumber(int visitNumber)
	{
		this.visitNumber = visitNumber;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setNome(String nome)
	{
		this.nome = nome;
	}
}
