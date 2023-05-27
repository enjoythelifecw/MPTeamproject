import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.teamprojectlogin.User_Model
import com.example.teamprojectlogin.databinding.ActivityMypageBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MypageFragment : Fragment() {
    private lateinit var binding: ActivityMypageBinding
    private lateinit var database: DatabaseReference

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = ActivityMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegisterMypage.setOnClickListener{
            val email = binding.etEmail.text.toString()
            val pw = binding.etPw.text.toString()
            val nickname = binding.etNickname.text.toString()
            val name = binding.etName.text.toString()
            val department = binding.etKaudepartment.text.toString()
            val kauid = binding.etKauID.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val user = User_Model(email, pw, nickname, name, department, kauid)

            database.child(nickname).setValue(user).addOnSuccessListener {
                binding.etEmail.text.clear()
                binding.etPw.text.clear()
                binding.etNickname.text.clear()
                binding.etName.text.clear()
                binding.etKaudepartment.text.clear()
                binding.etKauID.text.clear()

                Toast.makeText(requireContext(), "Successfully saved", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(requireContext(), "Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
