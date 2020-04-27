package com.ixuea.courses.helloworld.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;

import com.ixuea.courses.helloworld.R;

import java.lang.reflect.Method;

public class OptionMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu);
    }
    /*创建选项菜单*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test, menu);
        /*
          第一个int类型的group ID参数，代表的是组概念，你可以将几个菜单项归为一组，以便更好的以组的方式管理你的菜单按钮。
          第二个int类型的item ID参数，代表的是项目编号。这个参数非常重要，一个item ID对应一个menu中的选项。在后面使用菜单的时候，就靠这个item ID来判断你使用的是哪个选项。
          第三个int类型的order ID参数，代表的是菜单项的显示顺序。默认是0，表示菜单的显示顺序就是按照add的显示顺序来显示。
          第四个String类型的title参数，表示选项中显示的文字。
        */
        menu.add(1,100,Menu.CATEGORY_ALTERNATIVE,"第二个页面");//参数分别为分组的id、菜单项id值、菜单项排序、菜单描述
        SubMenu subMenu = menu.addSubMenu(1,101, Menu.CATEGORY_ALTERNATIVE,"二级菜单");
        //动态添加的菜单项只能手动添加icon了
        subMenu.add(1,102,Menu.NONE,"二级菜单选项1");
        subMenu.add(1,103,Menu.NONE,"二级菜单选项2");
        SubMenu subsubMenu = subMenu.addSubMenu(1,104, Menu.CATEGORY_ALTERNATIVE,"三级菜单");
        subsubMenu.add(1,105,Menu.NONE,"三级菜单选项1");
        subsubMenu.add(1,106,Menu.NONE,"三级菜单选项2");
        setIconsVisible(menu,true);
        setIconsVisible(subMenu,false);
        return true;
    }
    /*菜单点击事件*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//item为当前点击的菜单
        switch (item.getItemId()) {
            case R.id.action_set:
                Toast.makeText(OptionMenuActivity.this,"点击了设置菜单",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_sure:
                Toast.makeText(OptionMenuActivity.this,"点击了确定菜单",Toast.LENGTH_SHORT).show();
                break;
            case 100:
                Intent intent=new Intent(OptionMenuActivity.this, OptionMenu2Activity.class);//创建意图
                item.setIntent(intent);//跳转
                break;
            case 102:
                Toast.makeText(OptionMenuActivity.this, "子菜单选项1", Toast.LENGTH_SHORT).show();
                break;
            case 103:
                Toast.makeText(OptionMenuActivity.this, "子菜单选项2", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    /*反射得到menu的setOptionalIconsVisible方法，这样就可以看到icon了，谷歌真是司马了*/
    private void setIconsVisible(Menu menu, boolean flag) {
        //判断menu是否为空
        if(menu != null) {
            try {
                //如果不为空,就反射拿到menu的setOptionalIconsVisible方法
                Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                //暴力访问该方法
                method.setAccessible(true);
                //调用该方法显示icon
                method.invoke(menu, flag);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
