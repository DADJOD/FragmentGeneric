package com.example.fragmentgeneric

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun b1Click(view: View?) {
        // Используем транзакцию для добавления фрагмента
        // В рамках одной транзакции можно произвести
        // много операций по добавлению, замене и удалению фрагментов.
        // В конце требуется выполнить commit
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        // Нужно указать идентификтор лэйаута куда будет добавлен фрагмент
        transaction.replace(R.id.host, FirstFragment())
        // Если хотим иметь возможность "откатить" транзакцию по кнопке Back,
        // то нужно добавить ее в BackStack
        transaction.addToBackStack(null)

        // Завершаем транзакцию
        transaction.commit()
    }

    // Так можно задать цвет:
    // 0xccaabbcc
    // Color.black
    fun b2Click(view: View?) {
        // Используем статический конструктор для создания фрагментов с параметрами
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.host, GenericFragment.newInstance(0x7700FF00, "Second"))
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun b3Click(view: View?) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.host, GenericFragment.newInstance(0x77FF0000, "Third"))
        transaction.addToBackStack(null)
        transaction.commit()
    }
}