import { Injectable } from '@angular/core';

@Injectable()
export class NotificationService {
  private messages: string[] = [];

  addMessage(msg: string): void {
    const timestampedMsg = `[${new Date().toLocaleTimeString()}] ${msg}`;
    this.messages.push(timestampedMsg);
    console.log('Notification Logged:', timestampedMsg);
  }

  getMessages(): string[] {
    return this.messages;
  }
}
