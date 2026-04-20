import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<String> resultText = new MutableLiveData<>();
    private final MutableLiveData<Boolean> shouldClearData = new MutableLiveData<>(false);

    public void sendData(String text) {
        resultText.setValue(text);
    }

    public LiveData<String> getResultText() {
        return resultText;
    }

    public void clearAll() {
        resultText.setValue("");
        shouldClearData.setValue(true);
    }

    public LiveData<Boolean> getShouldClearData() {
        return shouldClearData;
    }

    public void setShouldClearData(boolean value) {
        shouldClearData.setValue(value);
    }
}