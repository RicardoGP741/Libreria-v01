package packagePrueba;

public class DocumentoOficial extends Documento{


	@Override
	protected void imprimirEncabezado() {
		// TODO Auto-generated method stub
		System.out.println("<oficial>encabezado del documento oficial<oficial>");
	}

	@Override
	protected void imprimirMensaje(String mensaje) {
		// TODO Auto-generated method stub
		System.out.println("<oficial>"+mensaje+"</oficial>");
	}

	@Override
	protected void imprimirPie() {
		// TODO Auto-generated method stub
		System.out.println("<oficial>pie del documento oficial<oficial>");
	}
	
}
