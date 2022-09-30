package packagePrueba;

public class GestionDocumentos {

	public static void main(String[] args) {
		Documento d = new DocumentoOficial();
		d.imprimir("Saludos cordiales");
		d = new DocumentoPlano();
		d.imprimir("que onda");
	}
}

