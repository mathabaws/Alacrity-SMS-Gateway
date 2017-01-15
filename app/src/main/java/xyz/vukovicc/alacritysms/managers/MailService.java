package xyz.vukovicc.alacritysms.managers;

import android.os.AsyncTask;

import com.sun.mail.imap.IMAPFolder;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 * Created by Matej on 11/20/2016.
 */

public class MailService extends AsyncTask<String,Void,String> {



    public static void checkEmail(String host, String storeType, String user, String password){
        IMAPFolder folder = null;
        Store store = null;
        String subject = null;
        Flags.Flag flag = null;
        try
        {
            Properties props = System.getProperties();
            props.setProperty("mail.store.protocol", "imaps");

            Session session = Session.getDefaultInstance(props, null);

            store = session.getStore("imaps");
            store.connect("imap.googlemail.com","matha.baws@gmail.com", "Vukovic.mat132");

            //folder = (IMAPFolder) store.getFolder("[Gmail]/Spam"); // This doesn't work for other email account
            folder = (IMAPFolder) store.getFolder("inbox");


            if(!folder.isOpen())
                folder.open(Folder.READ_WRITE);
            Message[] messages = folder.getMessages();
            System.out.println("No of Messages : " + folder.getMessageCount());
            System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
            System.out.println(messages.length);
            for (int i=0; i < 50;i++)
            {

                System.out.println("*****************************************************************************");
                System.out.println("MESSAGE " + (i + 1) + ":");
                Message msg =  messages[i];
                //System.out.println(msg.getMessageNumber());
                //Object String;
                //System.out.println(folder.getUID(msg)

                subject = msg.getSubject();

                System.out.println("Subject: " + subject);
                System.out.println("From: " + msg.getFrom()[0]);
                System.out.println("To: "+msg.getAllRecipients()[0]);
                System.out.println("Date: "+msg.getReceivedDate());
                System.out.println("Size: "+msg.getSize());
                System.out.println(msg.getFlags());
                System.out.println("Body: \n"+ msg.getContent());
                System.out.println(msg.getContentType());

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } finally
        {
            try {
                if (folder != null && folder.isOpen()) {
                    folder.close(true);
                }
                if (store != null) {
                    store.close();
                }
            } catch (MessagingException e) {
                    e.printStackTrace();
            }
        }
    }

    @Override
    protected String doInBackground(String... strings) {
        this.checkEmail("","","","");

        return "Done!";

    }
}

