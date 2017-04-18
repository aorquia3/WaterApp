//
//  SignInViewController.swift
//  ThirstQuencher
//
//  Created by Claire
//
import UIKit

class SignInViewController: UIViewController {
    
    @IBOutlet weak var usernameTextField: UITextField!
    @IBOutlet weak var passTextField: UITextField!
    @IBOutlet weak var loginButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
        
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // When Login Button is Pressed
    @IBAction func attemptLogin(_ sender: UIButton) {
        let userAlert = UIAlertController(title: "Username Error", message: "The username inputted does not exist.", preferredStyle: UIAlertControllerStyle.alert)
        userAlert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        
        let nullAlert = UIAlertController(title: "Error", message: "One of the fields is empty.", preferredStyle: UIAlertControllerStyle.alert)
        nullAlert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        
        let passAlert = UIAlertController(title: "Password Error", message: "Password does not match the user.", preferredStyle: UIAlertControllerStyle.alert)
        passAlert.addAction(UIAlertAction(title: "OK", style: UIAlertActionStyle.default, handler: nil))
        
        let username = usernameTextField.text
        let password = passTextField.text
        
        if (username == "" || password == "") {
            self.present(nullAlert, animated: true, completion:nil)
        }
        
        let checkUser = Model.sharedInstance.checkUser(id: username!, password: password!)
        
        if (checkUser == "Username does not exist") {
            self.present(userAlert, animated: true, completion: nil)
        } else if (checkUser == "Password does not exist") {
            self.present(passAlert, animated: true, completion: nil)
        } else {
            self.performSegue(withIdentifier: "toSuccessfulLogin", sender: nil)
        }
        
        
    }
    
  
    
}
