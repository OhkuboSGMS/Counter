package app.os.counter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by ookubo on 2016/11/01.
 */
public class CounterListFragment extends Fragment {
    public static final String ID ="@CounterListFragment";
    String test[] ={"筋トレ","Machin","オナニー"};
    ListView counterList;
    ArrayAdapter<String> counterListAdapter;
    TextView plusItem;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.counter_list_fragment_layout,null);
        View ll =inflater.inflate(R.layout.counter_list_footer,null);
        plusItem =(TextView)ll.findViewById(R.id.plusItem);
        counterList =(ListView)root.findViewById(R.id.listView);
        counterListAdapter =new ArrayAdapter<String>(getContext(),android.R.layout.test_list_item);
        counterList.setAdapter(counterListAdapter);
        counterList.addFooterView(plusItem);
        return  root;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        plusItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counterListAdapter.add("kik");
                counterList.setAdapter(counterListAdapter);
            }
        });
    }

    public ArrayAdapter<String>getAdapter(){
        return  counterListAdapter;
    }
}
