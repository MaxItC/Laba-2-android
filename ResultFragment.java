import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class ResultFragment extends Fragment {

    private SharedViewModel viewModel;

    public ResultFragment() {
        super(R.layout.fragment_result);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        TextView resultView = view.findViewById(R.id.textViewResult);
        Button btnCancel = view.findViewById(R.id.buttonCancel);

        viewModel.getResultText().observe(getViewLifecycleOwner(), resultView::setText);

        btnCancel.setOnClickListener(v -> viewModel.clearAll());
    }
}