package edu.zju.bme.clever.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;

@WebService(endpointInterface = "edu.zju.bme.clever.service.CleverService")
@BindingType(value = SOAPBinding.SOAP12HTTP_BINDING)
public class CleverServiceImpl implements CleverService {

	public CleverServiceImpl() {
	}

	@Override
	public int start() {

		return CleverServiceSingleton.INSTANCE.start();

	}

	@Override
	public int stop() {

		return CleverServiceSingleton.INSTANCE.stop();

	}

	@Override
	public boolean getServiceStatus() {

		return CleverServiceSingleton.INSTANCE.getServiceStatus();

	}

	@Override
	public int reconfigure(Collection<String> archetypes, Collection<String> arms) {

		return CleverServiceSingleton.INSTANCE.reconfigure(
				Optional.ofNullable(archetypes), Optional.ofNullable(arms));

	}

	@Override
	public List<String> select(String aql) {

		return CleverServiceSingleton.INSTANCE.select(Optional.ofNullable(aql));

	}

	@Override
	public long selectCount(String aql) {

		return CleverServiceSingleton.INSTANCE.selectCount(Optional.ofNullable(aql));

	}

	@Override
	public int insert(List<String> dadls) {

		return CleverServiceSingleton.INSTANCE.insert(Optional.ofNullable(dadls));

	}

	@Override
	public int delete(String aql) {

		return CleverServiceSingleton.INSTANCE.delete(Optional.ofNullable(aql));

	}

	@Override
	public int update(String aql) {

		return CleverServiceSingleton.INSTANCE.update(Optional.ofNullable(aql));

	}

	@Override
	public List<String> getSQL(String aql) {

		return CleverServiceSingleton.INSTANCE.getSQL(Optional.ofNullable(aql));

	}

	@Override
	public Set<String> getArchetypeIds() {

		return CleverServiceSingleton.INSTANCE.getArchetypeIds();
		
	}

	@Override
	public String getArchetypeString(String archetypeId) {

		return CleverServiceSingleton.INSTANCE.getArchetypeString(Optional.ofNullable(archetypeId));
		
	}

	@Override
	public Set<String> getArchetypeStrings(Set<String> archetypeIds) {
		
		return archetypeIds.stream().map(i -> getArchetypeString(i)).collect(Collectors.toSet());
		
	}

}
