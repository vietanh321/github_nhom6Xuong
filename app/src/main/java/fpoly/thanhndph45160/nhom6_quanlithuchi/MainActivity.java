package fpoly.thanhndph45160.nhom6_quanlithuchi;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout fragmentContainer;

    private HomeFragment homeFragment;
    private TransactionFragment transactionFragment;
    private Fragment3 fragment3;
    private Fragment4 fragment4;
    private Fragment5 fragment5;

    private ExpenseFragment expenseFragment;
    private IncomeFragment incomeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentContainer = findViewById(R.id.fragment_container);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        homeFragment = new HomeFragment();
        transactionFragment = new TransactionFragment();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();

        expenseFragment = new ExpenseFragment();
        incomeFragment = new IncomeFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, homeFragment)
                .commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.menu_item_1) {
                    selectedFragment = homeFragment;
                } else if (item.getItemId() == R.id.menu_item_2) {
                    selectedFragment = transactionFragment;
                } else if (item.getItemId() == R.id.menu_item_3) {
                    selectedFragment = fragment3;
                } else if (item.getItemId() == R.id.menu_item_4) {
                    selectedFragment = fragment4;
                } else if (item.getItemId() == R.id.menu_item_5) {
                    selectedFragment = fragment5;
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();

                return true;
            }
        });
    }
}