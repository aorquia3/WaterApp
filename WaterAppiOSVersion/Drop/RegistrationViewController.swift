//
//  RegistrationViewController.swift
//  Drop
//
//  Created by Claire
//

import UIKit

class RegistrationViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {

    @IBOutlet weak var username: UITextField!
    @IBOutlet weak var pass: UITextField!
    @IBOutlet weak var Name: UITextField!
    @IBOutlet weak var confirmPass: UITextField!
    @IBOutlet weak var accountTypeTextField: UITextField!
    
    var accountTypeData: [String] = [String]()
    var selectedAccountType = ""
    
    override func viewDidLoad() {
        
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        let pickerView = UIPickerView()
        pickerView.delegate = self
        accountTypeTextField.inputView = pickerView
        
        accountTypeData = ["User", "Worker", "Admin", "Manager"]
    }
    

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return accountTypeData.count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return accountTypeData[row]
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        accountTypeTextField.text = accountTypeData[row]
    }
    
    @IBAction func onRegister(_ sender: UIButton) {
        let user = username.text
        let password = pass.text
        let name = Name.text
        let confirm = confirmPass.text
        let accountType: AccountType
        let nullAlert = UIAlertController(title: "Error", message: "One of the fields is empty.", preferredStyle: UIAlertControllerStyle.alert)
        nullAlert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        let confirmAlert = UIAlertController(title: "Password Error", message: "Passwords don't match.", preferredStyle: UIAlertControllerStyle.alert)
        confirmAlert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        let userAlert = UIAlertController(title: "User Error", message: "User already exists.", preferredStyle: UIAlertControllerStyle.alert)
        userAlert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        if (accountTypeTextField.text == "Manager") {
            accountType = AccountType.MANAGER
        } else if (accountTypeTextField.text == "Worker") {
            accountType = AccountType.WORKER
        } else if (accountTypeTextField.text == "Admin") {
            accountType = AccountType.ADMIN
        } else {
            accountType = AccountType.USER
        }
        
        let registerConfirmed = UIAlertController(title: "Registration confirmed!", message: "Person was registered in the system.", preferredStyle: UIAlertControllerStyle.alert)
        registerConfirmed.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        registerConfirmed.addAction(UIAlertAction(title: "Sign In", style: UIAlertActionStyle.default, handler: { action in
            self.performSegue(withIdentifier: "showSignIn", sender: nil)
        }))
        
        
        if (user == "" || password == "" || name == "") {
            self.present(nullAlert, animated: true, completion:nil)
        } else if (password != confirm) {
            self.present(confirmAlert, animated: true, completion:nil)
        } else if (Model.sharedInstance.addUser(name: name!, id: user!, password: password!, accountType: accountType)) {
            self.present(registerConfirmed, animated: true, completion:nil)
        } else {
            self.present(userAlert, animated: true, completion:nil)
        }
    }
    
    @IBAction func userTappedBackground(sender: AnyObject) {
        view.endEditing(true)
    }


    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
    }
    */

}
