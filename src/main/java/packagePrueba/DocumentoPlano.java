package packagePrueba;

public class DocumentoPlano extends Documento{

	@Override
	protected void imprimirEncabezado() {
		// TODO Auto-generated method stub
		System.out.println("encabezado del documento oficial");
	}

	@Override
	protected void imprimirMensaje(String mensaje) {
		// TODO Auto-generated method stub
		System.out.println(mensaje);
	}

	@Override
	protected void imprimirPie() {
		// TODO Auto-generated method stub
		System.out.println("pie del documento oficial");
	}
	
}
