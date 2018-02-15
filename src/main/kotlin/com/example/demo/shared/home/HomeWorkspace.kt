package com.example.demo.shared.home

import javafx.application.Platform
import javafx.scene.control.Menu
import tornadofx.*


class HomeWorkspace : Workspace("JHipster FX") {
    val homeController : HomeController by inject()
    override fun onDock() {
        log.info("JDnfkjzsdnfkndf")
    }

    override fun onRefresh() {
        log.info("seger")
       // customerTable.asyncItems { customerController.listCustomers() }
    }
    init {
        menubar {
            menu("Entities") {
                item("New").action {
                    log.info("Opening text file")
                    dock(homeController.newEntity(), true)
                }
                separator()
                item("Close all").action {
                    workspace.dock(EmptyView(),true)
                }
                separator()
                openWindowMenuItemsAtfer()
            }
            menu("Administration"){
                item("Close all").action {
                    workspace.dock(EmptyView(),true)
                }
                separator()
                item("Exit").action {
                    log.info("Leaving workspace")
                    Platform.exit()
                }
            }
            menu("Language") {
                item("About...")
            }
            menu("Account") {
                item("About...")
            }
            menu("Exit").action {
                log.info("exit ")
                Platform.exit()
            }
        }

        dock(homeController.newEntity(),true)
        add(RestProgressBar::class)
        with(bottomDrawer) {
            item( "Logs") {
                textarea {
                    addClass("consola")

                }

            }
        }
    }

    /**
     * this extension method allows binding the open document's fragment to menu
     */
    private fun Menu.openWindowMenuItemsAtfer() {
        /*editorController.editorModelList.onChange { dvm ->
            dvm.next()
            if (dvm.wasAdded()) {
                dvm.addedSubList.forEach { x ->
                    val item = MenuItem(x.title)
                    item.action {
                        workspace.dock(x, true)
                    }
                    items.add(item)
                }
            } else if (dvm.wasRemoved()) {
                dvm.removed.forEach { x ->
                    workspace.viewStack.remove(x)
                    x.close()
                    println(workspace.dockedComponent)
                    val morituri = items.takeLast(items.size - 2).filter { item -> item.text.equals(x.title) }
                    items.removeAll(morituri)
                }
            }
        }*/
    }

}


class EmptyView : View() {
    //val controller: EditorController by inject()
    override val root = label("---------------")
}