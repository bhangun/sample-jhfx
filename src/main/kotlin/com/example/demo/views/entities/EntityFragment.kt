package com.example.demo.views.entities

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import java.time.LocalDate
import java.time.Period

class EntityFragment : Fragment("Entity View") {
    val person : PersonView by inject()
    override val root = borderpane()
    init{
        log.info("new entity fragment")
        with(root) {
            center = person.root
        }
    }
}

class EntityFragmentModel : ItemViewModel<EntityFragment>() {
    val root = bind(EntityFragment::root)
}


class PersonView : View() {
    private val persons = listOf(
            Person(1, "Samantha Stuart", LocalDate.of(1981,12,4)),
            Person(2, "Tom Marks", LocalDate.of(2001,1,23)),
            Person(3, "Stuart Gills", LocalDate.of(1989,5,23)),
            Person(3, "Nicole Williams", LocalDate.of(1998,8,11))
    ).observable()

    override val root = pane {

            tableview(persons) {
                column("ID", Person::idProperty)
                column("Name", Person::nameProperty)
                column("Birthday", Person::birthdayProperty)
                column("Age", Person::age)

        }
    }
}

class Person(id: Int, name: String, birthday: LocalDate) {
    val idProperty = SimpleIntegerProperty(id)
    var id by idProperty

    val nameProperty = SimpleStringProperty(name)
    var name by nameProperty

    val birthdayProperty = SimpleObjectProperty(birthday)
    var birthday by birthdayProperty

    val age: Int get() = Period.between(birthday, LocalDate.now()).years
}
