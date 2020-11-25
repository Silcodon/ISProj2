import java.io.IOException;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.NamingException;

import common.Publication;

@WebService
public interface PublicationWebServiceImpl {
	@WebMethod
	public List<Publication> Getall() throws NamingException, IOException;

	@WebMethod
	public List<Publication> GetPublicationByNome(String nome) throws NamingException, IOException;

	@WebMethod
	public List<Publication> GetPublicationByResearcher(String nome) throws NamingException, IOException;
	
}
