package santos.williankaminski.retrofit.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import santos.williankaminski.retrofit.model.CEP;

/**
 * @author Willian Kaminski
 * @since 11-07-2019
 */
public interface CEPService {

    @GET("{cep}/json/")
    Call<CEP> recuperarCEP(@Path("cep") String cep);

}
