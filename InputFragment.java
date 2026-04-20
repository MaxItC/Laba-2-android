import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class InputFragment extends Fragment {

    private SharedViewModel viewModel;

    public InputFragment() {
        super(R.layout.fragment_input); // Привязка разметки
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        EditText inputField = view.findViewById(R.id.editTextData);
        Button btnOk = view.findViewById(R.id.buttonOk);

        btnOk.setOnClickListener(v -> {
            String text = inputField.getText().toString();
            viewModel.sendData(text); // Передача данных 
        });

        viewModel.getShouldClearData().observe(getViewLifecycleOwner(), shouldClear -> {
            if (shouldClear) {
                inputField.setText("");
                viewModel.setShouldClearData(false);
            }
        });
    }
}