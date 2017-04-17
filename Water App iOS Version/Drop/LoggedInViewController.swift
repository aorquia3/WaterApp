//
//  LoggedInViewController.swift
//  ThirstQuencher
//
//  Created by Claire
//
import UIKit

class LoggedInViewController: UIViewController {
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let logoutButton: UIBarButtonItem = UIBarButtonItem(title: "Log out", style: .plain, target: self, action: "goToLogin")
        
        self.navigationItem.rightBarButtonItem = logoutButton;
        
        // Do any additional setup after loading the view.
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func goToLogin() {
        self.performSegue(withIdentifier: "logOutFromInitial", sender: nil)
    }
    
    
 
    
}
