package com.mycompany.pi;

import com.mycompany.pi.database.FuncionariosDAO;
import com.mycompany.pi.themes.tema;
import com.mycompany.pi.views.BemVindo;
import java.awt.Font;
import javax.swing.UIManager;

/**
 *
 * @author brand
 */
public class Pi {

    public static void main(String[] args) {
        tema.setup();

        // Definindo a mesma fonte para todos os elementos de texto do JFormFrame
        Font font = new Font("Liberation Sans", Font.PLAIN, 16);
        UIManager.put("TextField.font", font);
        UIManager.put("PasswordField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("TextPane.font", font);
        UIManager.put("EditorPane.font", font);
        UIManager.put("FormattedTextField.font", font);
        UIManager.put("Spinner.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("Label.font", font);
        UIManager.put("List.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("TabbedPane.font", font);
        UIManager.put("TitledBorder.font", font);
        UIManager.put("CheckBox.font", font);
        UIManager.put("CheckBoxMenuItem.font", font);
        UIManager.put("Menu.font", font);
        UIManager.put("PopupMenu.font", font);
        UIManager.put("OptionPane.font", font);
        UIManager.put("RadioButton.font", font);
        UIManager.put("RadioButtonMenuItem.font", font);
        UIManager.put("ToggleButton.font", font);
        UIManager.put("Tree.font", font);

        // cria funcionario admin
        FuncionariosDAO.criaFuncionarioAdmin();

        BemVindo bemVindo = new BemVindo();
        bemVindo.setLocationRelativeTo(null);
        bemVindo.setVisible(true);
    }
}
