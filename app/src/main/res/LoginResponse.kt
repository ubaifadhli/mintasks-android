
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("expires_in")
    val expiresIn: Int,
    @SerializedName("token")
    val token: String,
    @SerializedName("token_type")
    val tokenType: String
)