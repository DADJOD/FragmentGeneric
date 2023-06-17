package com.example.fragmentgeneric

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.jetbrains.annotations.Nullable


class GenericFragment : Fragment() {
    /*
        Так делать нельзя!
        Конструктор не будет вызван при пересоздании фрагмента
        при изменении конфигурации устройства.
        Нужно использовать статическую инициализацию
    public GenericFragment(int color, String data)
    {

    }
    */
    // Параметры view, которые будем менять -
    // инициализируются в конструкторе
    private var backgroundColor = 0
    private var title: String? = null
    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle: Bundle? = arguments
        // Инициализируем данными из бандла
        if (bundle != null) {
            if (bundle.containsKey(FRAGMENT_COLOR)) {
                backgroundColor = bundle.getInt(FRAGMENT_COLOR)
            }
            if (bundle.containsKey(FRAGMENT_TITLE)) {
                title = bundle.getString(FRAGMENT_TITLE)
            }
        }
    }

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?,
    ): View {
        // Создаем иерархию вью
        val view: View = inflater.inflate(R.layout.fragment_generic, container, false)

        // Найдем нужные вью, чтобы поменять их атрибуты
//        val relative = view.findViewById<View>(R.id.relative) as RelativeLayout
//        relative.setBackgroundColor(backgroundColor)
//        val text = view.findViewById<View>(R.id.text) as TextView
//        text.text = title
//        return view

        val relative = view.findViewById<RelativeLayout>(R.id.relative)
        val text = view.findViewById<TextView>(R.id.text)

        // Поменяем их атрибуты
        relative.setBackgroundColor(backgroundColor)
        text.text = title

        return view
    }

    companion object {
        // Ключи для сохранения настроек
        private const val FRAGMENT_COLOR = "FRAGMENT_COLOR"
        private const val FRAGMENT_TITLE = "FRAGMENT_TITLE"

        // Статический инициализатор
        // 1. Создает фрагмент
        // 2. Создает бандл
        // 3. Сохраняет в бандл аргументы
        // 4. Присоединяет бандл к возвращаемому фрагменту
        // Инициализация параметрами из бандла происходит в onCreate
        // Используется для создания фрагментов которым нужно передать
        // входные параметры (возможно различные)
        fun newInstance(color: Int, data: String?): GenericFragment {
            val fragment = GenericFragment()
            val bundle = Bundle()
            bundle.putInt(FRAGMENT_COLOR, color)
            bundle.putString(FRAGMENT_TITLE, data)
            fragment.arguments = bundle

            return fragment
        }
    }
}